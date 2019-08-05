package com.gutotech.narutogame.fragment.logado;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gutotech.narutogame.R;
import com.gutotech.narutogame.activity.LogadoSelecionarActivity;
import com.gutotech.narutogame.config.ConfigFirebase;
import com.gutotech.narutogame.helper.DateCustom;
import com.gutotech.narutogame.helper.Permissao;
import com.gutotech.narutogame.model.Player;
import com.gutotech.narutogame.model.Ticket;

import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.UUID;

public class SuporteNovoFragment extends Fragment {
    private EditText tituloEditText;

    private EditText quandoOcorreuEditText;
    private CalendarView calendarView;

    private EditText descricaoEditText;

    private Ticket ticket;

    private String[] permissoesNecessarias = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    private ImageButton anexarImageButton;
    private TextView nomeDoArquivoTextView;

    public SuporteNovoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suporte_novo, container, false);
        LogadoSelecionarActivity.tituloSecaoTextView.setText("SUPORTE - NOVO TICKET DE SUPORTE");

        ticket = new Ticket();
        ticket.setCategoria("Bug");

        ArrayAdapter<CharSequence> adapter;

        final Spinner categoriaSpinner = view.findViewById(R.id.categoriaSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.categorias_array, android.R.layout.simple_spinner_item);
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
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horasSpinner.setAdapter(adapter);
        horasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Spinner minutosSpinner = view.findViewById(R.id.quandoMinutosSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexos_array1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minutosSpinner.setAdapter(adapter);
        minutosSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final TextView caracteresRestantesTextView = view.findViewById(R.id.caracteresRestantesTextView);

        descricaoEditText = view.findViewById(R.id.descricaoEditText);
        descricaoEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int caracteresRestante = 5000 - descricaoEditText.getText().toString().length();

                caracteresRestantesTextView.setText("Caracteres restantes: " + caracteresRestante);
            }
        });
        descricaoEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int caracteresRestante = 5000 - descricaoEditText.getText().toString().length() - 1;
                exibirAlerta("teste");
                caracteresRestantesTextView.setText(String.valueOf(caracteresRestante));
                return false;
            }
        });

        // validar permissões
        Permissao.validarPermissoes(permissoesNecessarias, getActivity(), 1);

        nomeDoArquivoTextView = view.findViewById(R.id.nomeDoArquivoTextView);
        anexarImageButton = view.findViewById(R.id.anexarImageButton);
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
                    ticket.setDataCriacao(DateCustom.dataAtual());
                    ticket.setDataAtualizacao(DateCustom.dataAtual());

                    String horario = DateCustom.horarioAtual();
                    ticket.setHoraCriacao(horario);
                    ticket.setHoraAtualizacao(horario);

                    ticket.setDescricao(descricao);
                    ticket.setStatus("Novo");
                    ticket.setEmail(ConfigFirebase.getAuth().getCurrentUser().getEmail());
                    ticket.setUltimoAResponder("--");

                    salvarTicket(ticket);

                    SuporteFragment suporteFragment = new SuporteFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ticket criado", 1);
                    suporteFragment.setArguments(bundle);
                    changeToFragment(suporteFragment);
                }
            }
        });
        return view;
    }

    private void salvarTicket(Ticket ticket) {
        DatabaseReference ticketReference = ConfigFirebase.getDatabase()
                .child("tickets")
                .push();

        ticketReference.setValue(ticket);
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
                    StorageReference imagemRef = ConfigFirebase.getStorage()
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

    private boolean validarCampos(String titulo, String data, String descricao) {
        String errorMessage = "";

        if (titulo.isEmpty())
            errorMessage = "Título invalido\n";

        if (descricao.isEmpty())
            errorMessage += "Descrição invalida\n";

        if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            errorMessage += "Data inválida";
        }

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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int permissaoResultado : grantResults) {
            if (permissaoResultado == PackageManager.PERMISSION_DENIED)
                alertaValidacaoPermissao();
        }
    }

    private void alertaValidacaoPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para fazer o upload imagem é necessário aceitar as permissões");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                anexarImageButton.setEnabled(false);
            }
        });
        builder.create();
        builder.show();
    }

    private void changeToFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment).commit();
    }
}
