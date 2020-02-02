package com.gutotech.narutogame.data.model;

import android.content.Context;

import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.List;

public enum MissionInfo {
    TASK1(R.string.task_first_lesson, R.string.task_first_lesson_des, R.string.task_msg_finished1,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 800;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 1;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK2(R.string.task_second_lesson, R.string.task_second_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 800;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 1;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK3(R.string.task_third_lesson, R.string.task_third_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1000;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 2;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK4(R.string.task_lesson_four, R.string.task_lesson_four_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1000;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 2;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK5(R.string.task_fifth_lesson, R.string.task_fifth_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1200;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 3;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK6(R.string.task_sixth_lesson, R.string.task_sixth_lesson_des, R.string.task_msg_finished3,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1200;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 1400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 3;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK7(R.string.task_seventh_lesson, R.string.task_seventh_lesson_des, R.string.task_msg_finished4,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 4;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK8(R.string.task_lesson_eight, R.string.task_lesson_eight_des, R.string.task_msg_finished4,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 1600;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 4;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK9(R.string.task_lesson_9, R.string.task_lesson_9_des, R.string.task_msg_finished5,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 4;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK),
    TASK10(R.string.task_tenth_lesson, R.string.task_tenth_lesson_des, R.string.task_msg_finished10,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 1600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 25;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }),
            Arrays.asList(new Requirement() {
                @Override
                public Object value() {
                    return 4;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getLevel() >= (int) value();
                }

                @Override
                public String toString(Context context) {
                    return "Lvl. " + (int) value();
                }
            }),
            Mission.MissionRank.TASK);

    @StringRes
    public final int title;

    @StringRes
    public final int description;

    @StringRes
    public final int msgFinished;

    public final List<Reward> rewards;
    public final List<Requirement> requirements;
    public final Mission.MissionRank rank;

    MissionInfo(@StringRes int title, @StringRes int description, @StringRes int msgFinished,
                List<Reward> rewards, List<Requirement> requirements, Mission.MissionRank rank) {
        this.title = title;
        this.description = description;
        this.msgFinished = msgFinished;
        this.rewards = rewards;
        this.requirements = requirements;
        this.rank = rank;
    }
}
