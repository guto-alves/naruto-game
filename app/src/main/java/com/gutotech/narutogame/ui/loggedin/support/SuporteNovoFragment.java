package com.gutotech.narutogame.ui.loggedin.support;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.firebase.FirebaseConfig;
import com.gutotech.narutogame.data.repository.AuthRepository;
import com.gutotech.narutogame.utils.DateCustom;
import com.gutotech.narutogame.data.model.Ticket;
import com.gutotech.narutogame.utils.FragmentUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class SuporteNovoFragment extends Fragment {
    private EditText tituloEditText;

    private EditText quandoOcorreuEditText;
    private CalendarView calendarView;

    private TextInputEditText descricaoEditText;

    private Ticket ticket;

    private ImageButton anexarImageButton;
    private TextView nomeDoArquivoTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suporte_novo, container, false);

        FragmentUtil.setSectionTitle(getActivity(), R.string.section_support_new_ticket);

        ticket = new Ticket();
        ticket.setCategoria("Bug");
        ticket.setHoraOcorrido("00:00");

        ArrayAdapter<CharSequence> adapter;

        final Spinner categoriaSpinner = view.findViewById(R.id.categoriesSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.ticket_categories_list,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriaSpinner.setAdapter(adapter);
        categoriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ticket.setCategoria((String) categoriaSpinner.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tituloEditText = view.findViewById(R.id.tituloEditText);

        quandoOcorreuEditText = view.findViewById(R.id.dataQuandoOcorreuEditText);
        quandoOcorreuEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    calendarView.setVisibility(View.VISIBLE);
                else
                    calendarView.setVisibility(View.GONE);
            }
        });

        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setVisibility(View.GONE);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String data = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, month, year);
                ticket.setDataCriacao(data);
                quandoOcorreuEditText.setText(data);
                calendarView.setVisibility(View.GONE);
            }
        });

        final Spinner horasSpinner = view.findViewById(R.id.quandoHorasSpinner);
        final Spinner minutosSpinner = view.findViewById(R.id.quandoMinutosSpinner);

        List<String> horasList = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            horasList.add(String.format(Locale.getDefault(), "%02d", i));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, horasList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horasSpinner.setAdapter(arrayAdapter);
        horasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ticket.setHoraOcorrido(String.format(Locale.getDefault(), "%s:%s", horasSpinner.getSelectedItem(), minutosSpinner.getSelectedItem()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> minutosList = new ArrayList<>();
        for (int i = 0; i < 60; i++)
            minutosList.add(String.format(Locale.getDefault(), "%02d", i));

        ArrayAdapter<String> minutosAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, minutosList);
        minutosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minutosSpinner.setAdapter(minutosAdapter);
        minutosSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        descricaoEditText = view.findViewById(R.id.descricaoEditText);

        nomeDoArquivoTextView = view.findViewById(R.id.fileNameTextView);

        // pedir permisssões
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        anexarImageButton = view.findViewById(R.id.attachImageButton);
        anexarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null)
                    startActivityForResult(intent, 200);
            }
        });

        Button criarTicketButton = view.findViewById(R.id.criarTicketButton);
        criarTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = tituloEditText.getText().toString();
                String data = quandoOcorreuEditText.getText().toString();
                String descricao = descricaoEditText.getText().toString();

                if (validarCampos(titulo, data, descricao)) {
                    ticket.setTitulo(titulo);
                    ticket.setDataOcorrido(data);
                    ticket.setDataCriacao(DateCustom.getDate());
                    ticket.setDataAtualizacao(DateCustom.getDate());

                    String horario = DateCustom.getTime();
                    ticket.setHoraCriacao(horario);
                    ticket.setHoraAtualizacao(horario);

                    ticket.setDescricao(descricao);
                    ticket.setStatus("Novo");
                    ticket.setEmail(AuthRepository.getInstance().getCurrentUser().getEmail());
                    ticket.setUltimoAResponder("--");

                    salvarTicket(ticket);

                    SuporteFragment suporteFragment = new SuporteFragment();
                    suporteFragment.setArguments(new Bundle());
                    changeToFragment(suporteFragment);
                }
            }
        });

        return view;
    }

    private void salvarTicket(Ticket ticket) {
        DatabaseReference ticketReference = FirebaseConfig.getDatabase()
                .child("tickets")
                .push();

        ticketReference.setValue(ticket);
    }

    private boolean validarCampos(String titulo, String data, String descricao) {
        String errorMessage = "";

        if (titulo.isEmpty())
            errorMessage = "Título invalido\n";

        if (descricao.isEmpty())
            errorMessage += "Descrição invalida\n";

        if (!data.matches("\\d{2}/\\d{2}/\\d{4}"))
            errorMessage += "Data inválida";

        if (errorMessage.isEmpty())
            return true;
        else {
            exibirAlerta(errorMessage);
            return false;
        }
    }

    private void exibirAlerta(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("PROBLEMA");
        builder.setMessage("Os seguintes problemas impediram que seu ticket fosse criado:\n\n" + message);
        builder.setPositiveButton("OK", null);
        builder.setCancelable(false);
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
            Bitmap imagem = null;

            try {
                if (requestCode == 200) {
                    Uri localImagemSelecionada = data.getData();
                    imagem = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), localImagemSelecionada);
                }

                if (imagem != null) {
                    // recuperar dodos da imagem para o firebase
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    imagem.compress(Bitmap.CompressFormat.JPEG, 70, baos);
                    byte[] dadosImagem = baos.toByteArray();

                    final String nomeDaImagem = UUID.randomUUID().toString() + ".jpg";
                    // Salvar imagem no firebase
                    StorageReference imagemRef = FirebaseConfig.getStorage()
                            .child("images")
                            .child("ticket")
                            .child(nomeDaImagem);

                    UploadTask uploadTask = imagemRef.putBytes(dadosImagem);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Erro ao fazer upload da imagem", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getActivity(), "Sucesso ao fazer upload da imagem", Toast.LENGTH_SHORT).show();

                            taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener
                                    (new OnSuccessListener<Uri>() {
                                         @Override
                                         public void onSuccess(Uri uri) {
                                             nomeDoArquivoTextView.setText(nomeDaImagem);
                                             ticket.setImagem(nomeDaImagem);
                                         }
                                     }
                                    );
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int permissaoResultado : grantResults) {
            if (permissaoResultado == PackageManager.PERMISSION_DENIED) {
                anexarImageButton.setEnabled(false);
                alertaValidacaoPermissao();
            }
        }
    }

    private void alertaValidacaoPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para anexar uma imagem do problema é necessário aceitar a permissão");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", null);
        builder.create();
        builder.show();
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }
}
