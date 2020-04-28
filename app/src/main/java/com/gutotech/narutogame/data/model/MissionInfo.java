package com.gutotech.narutogame.data.model;

import android.content.Context;

import androidx.annotation.StringRes;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MissionInfo {
    TASK1(R.string.task_first_lesson, R.string.task_first_lesson_des, R.string.task_msg_finished1,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK2(R.string.task_second_lesson, R.string.task_second_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK3(R.string.task_third_lesson, R.string.task_third_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK4(R.string.task_lesson_four, R.string.task_lesson_four_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK5(R.string.task_fifth_lesson, R.string.task_fifth_lesson_des, R.string.task_msg_finished2,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK6(R.string.task_sixth_lesson, R.string.task_sixth_lesson_des, R.string.task_msg_finished3,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK7(R.string.task_seventh_lesson, R.string.task_seventh_lesson_des, R.string.task_msg_finished4,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK8(R.string.task_lesson_eight, R.string.task_lesson_eight_des, R.string.task_msg_finished4,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK9(R.string.task_lesson_9, R.string.task_lesson_9_des, R.string.task_msg_finished5,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            Mission.Type.TIME, Mission.Rank.TASK),
    TASK10(R.string.task_tenth_lesson, R.string.task_tenth_lesson_des, R.string.task_msg_finished10,
            Arrays.asList(new Reward() {
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
            }, new Reward() {
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
            }),
            Collections.singletonList(new Requirement() {
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
            Mission.Type.TIME, Mission.Rank.TASK),


    MISSION1(R.string.mission1, R.string.mission1_description, R.string.mission1_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION2(R.string.mission2, R.string.mission2_description, R.string.mission2_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION3(R.string.mission3, R.string.mission3_description, R.string.mission3_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION4(R.string.mission4, R.string.mission4_description, R.string.mission4_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION5(R.string.mission5, R.string.mission5_description, R.string.mission5_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION6(R.string.mission6, R.string.mission6_description, R.string.mission6_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 500;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION7(R.string.mission7, R.string.mission7_description, R.string.mission7_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 500;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION8(R.string.mission8, R.string.mission8_description, R.string.mission8_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 500;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION9(R.string.mission9, R.string.mission9_description, R.string.mission9_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 500;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION10(R.string.mission10, R.string.mission10_description, R.string.mission10_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION11(R.string.mission11, R.string.mission11_description, R.string.mission11_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION12(R.string.mission12, R.string.mission12_description, R.string.mission12_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION13(R.string.mission13, R.string.mission13_description, R.string.mission13_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION14(R.string.mission14, R.string.mission14_description, R.string.mission14_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION15(R.string.mission15, R.string.mission15_description, R.string.mission15_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 525;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION16(R.string.mission16, R.string.mission16_description, R.string.mission16_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 525;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION17(R.string.mission17, R.string.mission17_description, R.string.mission17_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 525;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION18(R.string.mission18, R.string.mission18_description, R.string.mission18_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 525;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 6;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION19(R.string.mission19, R.string.mission19_description, R.string.mission19_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION20(R.string.mission20, R.string.mission20_description, R.string.mission20_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION21(R.string.mission21, R.string.mission21_description, R.string.mission21_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION22(R.string.mission22, R.string.mission22_description, R.string.mission22_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION23(R.string.mission23, R.string.mission23_description, R.string.mission23_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION24(R.string.mission24, R.string.mission24_description, R.string.mission24_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 540;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION25(R.string.mission25, R.string.mission25_description, R.string.mission25_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 540;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION26(R.string.mission26, R.string.mission26_description, R.string.mission26_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 540;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION27(R.string.mission27, R.string.mission27_description, R.string.mission27_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 540;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 7;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION28(R.string.mission28, R.string.mission28_description, R.string.mission28_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION29(R.string.mission29, R.string.mission29_description, R.string.mission29_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION30(R.string.mission30, R.string.mission30_description, R.string.mission30_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION31(R.string.mission31, R.string.mission31_description, R.string.mission31_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION32(R.string.mission32, R.string.mission32_description, R.string.mission32_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION33(R.string.mission33, R.string.mission33_description, R.string.mission33_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 560;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION34(R.string.mission34, R.string.mission34_description, R.string.mission34_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 560;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION35(R.string.mission35, R.string.mission35_description, R.string.mission35_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 560;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION36(R.string.mission36, R.string.mission36_description, R.string.mission36_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 560;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 8;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION37(R.string.mission37, R.string.mission37_description, R.string.mission37_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION38(R.string.mission38, R.string.mission38_description, R.string.mission38_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION39(R.string.mission39, R.string.mission39_description, R.string.mission39_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION40(R.string.mission40, R.string.mission40_description, R.string.mission40_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION41(R.string.mission41, R.string.mission41_description, R.string.mission41_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION42(R.string.mission42, R.string.mission42_description, R.string.mission42_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 580;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION43(R.string.mission43, R.string.mission43_description, R.string.mission43_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 580;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION44(R.string.mission44, R.string.mission44_description, R.string.mission44_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 580;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION45(R.string.mission45, R.string.mission45_description, R.string.mission45_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 580;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION46(R.string.mission46, R.string.mission46_description, R.string.mission46_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION47(R.string.mission47, R.string.mission47_description, R.string.mission47_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION48(R.string.mission48, R.string.mission48_description, R.string.mission48_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION49(R.string.mission49, R.string.mission49_description, R.string.mission49_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION50(R.string.mission50, R.string.mission50_description, R.string.mission50_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION51(R.string.mission51, R.string.mission51_description, R.string.mission51_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION52(R.string.mission52, R.string.mission52_description, R.string.mission52_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION53(R.string.mission53, R.string.mission53_description, R.string.mission53_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION54(R.string.mission54, R.string.mission54_description, R.string.mission54_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 10;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION55(R.string.mission55, R.string.mission55_description, R.string.mission55_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION56(R.string.mission56, R.string.mission56_description, R.string.mission56_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION57(R.string.mission57, R.string.mission57_description, R.string.mission57_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION58(R.string.mission58, R.string.mission58_description, R.string.mission58_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION59(R.string.mission59, R.string.mission59_description, R.string.mission59_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION60(R.string.mission60, R.string.mission60_description, R.string.mission60_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 620;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION61(R.string.mission61, R.string.mission61_description, R.string.mission61_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 620;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION62(R.string.mission62, R.string.mission62_description, R.string.mission62_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 620;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION63(R.string.mission63, R.string.mission63_description, R.string.mission63_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 620;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 11;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION64(R.string.mission64, R.string.mission64_description, R.string.mission64_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION65(R.string.mission65, R.string.mission65_description, R.string.mission65_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION66(R.string.mission66, R.string.mission66_description, R.string.mission66_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION67(R.string.mission67, R.string.mission67_description, R.string.mission67_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION68(R.string.mission68, R.string.mission68_description, R.string.mission68_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION69(R.string.mission69, R.string.mission69_description, R.string.mission69_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 640;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION70(R.string.mission70, R.string.mission70_description, R.string.mission70_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 640;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION71(R.string.mission71, R.string.mission71_description, R.string.mission71_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 640;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION72(R.string.mission72, R.string.mission72_description, R.string.mission72_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 640;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 12;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION73(R.string.mission73, R.string.mission73_description, R.string.mission73_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION74(R.string.mission74, R.string.mission74_description, R.string.mission74_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION75(R.string.mission75, R.string.mission75_description, R.string.mission75_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION76(R.string.mission76, R.string.mission76_description, R.string.mission76_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION77(R.string.mission77, R.string.mission77_description, R.string.mission77_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION78(R.string.mission78, R.string.mission78_description, R.string.mission78_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 660;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION79(R.string.mission79, R.string.mission79_description, R.string.mission79_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 660;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION80(R.string.mission80, R.string.mission80_description, R.string.mission80_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 660;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION81(R.string.mission81, R.string.mission81_description, R.string.mission81_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 660;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 5;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION82(R.string.mission82, R.string.mission82_description, R.string.mission82_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION83(R.string.mission83, R.string.mission83_description, R.string.mission83_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION84(R.string.mission84, R.string.mission84_description, R.string.mission84_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION85(R.string.mission85, R.string.mission85_description, R.string.mission85_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION86(R.string.mission86, R.string.mission86_description, R.string.mission86_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 200;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION87(R.string.mission87, R.string.mission87_description, R.string.mission87_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 680;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION88(R.string.mission88, R.string.mission88_description, R.string.mission88_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 680;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D), MISSION89(R.string.mission89, R.string.mission89_description, R.string.mission89_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 680;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION90(R.string.mission90, R.string.mission90_description, R.string.mission90_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 100;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 680;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 14;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),
    MISSION91(R.string.mission91, R.string.mission91_description, R.string.mission91_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 250;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 600;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 1;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 15;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_D),

    MISSION92(R.string.mission92, R.string.mission92_description, R.string.mission92_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 15;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION93(R.string.mission93, R.string.mission93_description, R.string.mission93_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 15;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION94(R.string.mission94, R.string.mission94_description, R.string.mission94_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 15;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION95(R.string.mission95, R.string.mission95_description, R.string.mission95_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 15;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION96(R.string.mission96, R.string.mission96_description, R.string.mission96_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION97(R.string.mission97, R.string.mission97_description, R.string.mission97_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION98(R.string.mission98, R.string.mission98_description, R.string.mission98_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION99(R.string.mission99, R.string.mission99_description, R.string.mission99_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION100(R.string.mission100, R.string.mission100_description, R.string.mission100_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION101(R.string.mission101, R.string.mission101_description, R.string.mission101_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION102(R.string.mission102, R.string.mission102_description, R.string.mission102_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION103(R.string.mission103, R.string.mission103_description, R.string.mission103_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION104(R.string.mission104, R.string.mission104_description, R.string.mission104_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION105(R.string.mission105, R.string.mission105_description, R.string.mission105_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION106(R.string.mission106, R.string.mission106_description, R.string.mission106_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION107(R.string.mission107, R.string.mission107_description, R.string.mission107_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION108(R.string.mission108, R.string.mission108_description, R.string.mission108_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION109(R.string.mission109, R.string.mission109_description, R.string.mission109_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION110(R.string.mission110, R.string.mission110_description, R.string.mission110_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION111(R.string.mission111, R.string.mission111_description, R.string.mission111_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION112(R.string.mission112, R.string.mission112_description, R.string.mission112_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 17;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION113(R.string.mission113, R.string.mission113_description, R.string.mission113_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION114(R.string.mission114, R.string.mission114_description, R.string.mission114_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION115(R.string.mission115, R.string.mission115_description, R.string.mission115_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION116(R.string.mission116, R.string.mission116_description, R.string.mission116_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION117(R.string.mission117, R.string.mission117_description, R.string.mission117_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION118(R.string.mission118, R.string.mission118_description, R.string.mission118_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION119(R.string.mission119, R.string.mission119_description, R.string.mission119_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION120(R.string.mission120, R.string.mission120_description, R.string.mission120_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 18;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION121(R.string.mission121, R.string.mission121_description, R.string.mission121_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION122(R.string.mission122, R.string.mission122_description, R.string.mission122_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION123(R.string.mission123, R.string.mission123_description, R.string.mission123_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION124(R.string.mission124, R.string.mission124_description, R.string.mission124_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION125(R.string.mission125, R.string.mission125_description, R.string.mission125_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION126(R.string.mission126, R.string.mission126_description, R.string.mission126_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION127(R.string.mission127, R.string.mission127_description, R.string.mission127_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 19;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION128(R.string.mission128, R.string.mission128_description, R.string.mission128_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION129(R.string.mission129, R.string.mission129_description, R.string.mission129_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION130(R.string.mission130, R.string.mission130_description, R.string.mission130_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION131(R.string.mission131, R.string.mission131_description, R.string.mission131_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION132(R.string.mission132, R.string.mission132_description, R.string.mission132_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION133(R.string.mission133, R.string.mission133_description, R.string.mission133_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION134(R.string.mission134, R.string.mission134_description, R.string.mission134_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION135(R.string.mission135, R.string.mission135_description, R.string.mission135_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION136(R.string.mission136, R.string.mission136_description, R.string.mission136_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION137(R.string.mission137, R.string.mission137_description, R.string.mission137_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION138(R.string.mission138, R.string.mission138_description, R.string.mission138_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION139(R.string.mission139, R.string.mission139_description, R.string.mission139_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION140(R.string.mission140, R.string.mission140_description, R.string.mission140_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION141(R.string.mission141, R.string.mission141_description, R.string.mission141_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION142(R.string.mission142, R.string.mission142_description, R.string.mission142_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION143(R.string.mission143, R.string.mission143_description, R.string.mission143_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION144(R.string.mission144, R.string.mission144_description, R.string.mission144_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 21;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION145(R.string.mission145, R.string.mission145_description, R.string.mission145_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION146(R.string.mission146, R.string.mission146_description, R.string.mission146_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION147(R.string.mission147, R.string.mission147_description, R.string.mission147_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION148(R.string.mission148, R.string.mission148_description, R.string.mission148_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION149(R.string.mission149, R.string.mission149_description, R.string.mission149_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION150(R.string.mission150, R.string.mission150_description, R.string.mission150_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION151(R.string.mission151, R.string.mission151_description, R.string.mission151_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION152(R.string.mission152, R.string.mission152_description, R.string.mission152_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION153(R.string.mission153, R.string.mission153_description, R.string.mission153_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION154(R.string.mission154, R.string.mission154_description, R.string.mission154_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION155(R.string.mission155, R.string.mission155_description, R.string.mission155_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION156(R.string.mission156, R.string.mission156_description, R.string.mission156_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION157(R.string.mission157, R.string.mission157_description, R.string.mission157_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION158(R.string.mission158, R.string.mission158_description, R.string.mission158_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION159(R.string.mission159, R.string.mission159_description, R.string.mission159_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 23;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION160(R.string.mission160, R.string.mission160_description, R.string.mission160_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION161(R.string.mission161, R.string.mission161_description, R.string.mission161_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C), MISSION162(R.string.mission162, R.string.mission162_description, R.string.mission162_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION163(R.string.mission163, R.string.mission163_description, R.string.mission163_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION164(R.string.mission164, R.string.mission164_description, R.string.mission164_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION165(R.string.mission165, R.string.mission165_description, R.string.mission165_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION166(R.string.mission166, R.string.mission166_description, R.string.mission166_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION167(R.string.mission167, R.string.mission167_description, R.string.mission167_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 150;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
                @Override
                public int value() {
                    return 700;
                }

                @Override
                public void receive() {
                    CharOn.character.incrementExp(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.label_experience_points, value());
                }
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 2;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 24;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_C),
    MISSION168(R.string.mission168, R.string.mission168_description, R.string.mission168_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 25;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION169(R.string.mission169, R.string.mission169_description, R.string.mission169_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 25;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION170(R.string.mission170, R.string.mission170_description, R.string.mission170_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 25;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION171(R.string.mission171, R.string.mission171_description, R.string.mission171_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 25;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION172(R.string.mission172, R.string.mission172_description, R.string.mission172_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 25;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION173(R.string.mission173, R.string.mission173_description, R.string.mission173_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION174(R.string.mission174, R.string.mission174_description, R.string.mission174_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION175(R.string.mission175, R.string.mission175_description, R.string.mission175_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION176(R.string.mission176, R.string.mission176_description, R.string.mission176_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION177(R.string.mission177, R.string.mission177_description, R.string.mission177_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION178(R.string.mission178, R.string.mission178_description, R.string.mission178_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION179(R.string.mission179, R.string.mission179_description, R.string.mission179_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 26;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION180(R.string.mission180, R.string.mission180_description, R.string.mission180_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION181(R.string.mission181, R.string.mission181_description, R.string.mission181_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION182(R.string.mission182, R.string.mission182_description, R.string.mission182_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION183(R.string.mission183, R.string.mission183_description, R.string.mission183_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION184(R.string.mission184, R.string.mission184_description, R.string.mission184_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION185(R.string.mission185, R.string.mission185_description, R.string.mission185_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION186(R.string.mission186, R.string.mission186_description, R.string.mission186_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION187(R.string.mission187, R.string.mission187_description, R.string.mission187_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 27;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION188(R.string.mission188, R.string.mission188_description, R.string.mission188_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION189(R.string.mission189, R.string.mission189_description, R.string.mission189_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION190(R.string.mission190, R.string.mission190_description, R.string.mission190_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION191(R.string.mission191, R.string.mission191_description, R.string.mission191_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION192(R.string.mission192, R.string.mission192_description, R.string.mission192_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION193(R.string.mission193, R.string.mission193_description, R.string.mission193_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION194(R.string.mission194, R.string.mission194_description, R.string.mission194_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION195(R.string.mission195, R.string.mission195_description, R.string.mission195_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION196(R.string.mission196, R.string.mission196_description, R.string.mission196_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION197(R.string.mission197, R.string.mission197_description, R.string.mission197_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION198(R.string.mission198, R.string.mission198_description, R.string.mission198_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION199(R.string.mission199, R.string.mission199_description, R.string.mission199_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION200(R.string.mission200, R.string.mission200_description, R.string.mission200_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION201(R.string.mission201, R.string.mission201_description, R.string.mission201_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION202(R.string.mission202, R.string.mission202_description, R.string.mission202_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 29;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION203(R.string.mission203, R.string.mission203_description, R.string.mission203_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION204(R.string.mission204, R.string.mission204_description, R.string.mission204_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION205(R.string.mission205, R.string.mission205_description, R.string.mission205_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION206(R.string.mission206, R.string.mission206_description, R.string.mission206_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION207(R.string.mission207, R.string.mission207_description, R.string.mission207_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION208(R.string.mission208, R.string.mission208_description, R.string.mission208_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B),
    MISSION209(R.string.mission209, R.string.mission209_description, R.string.mission209_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION210(R.string.mission210, R.string.mission210_description, R.string.mission210_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 30;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION211(R.string.mission211, R.string.mission211_description, R.string.mission211_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION212(R.string.mission212, R.string.mission212_description, R.string.mission212_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION213(R.string.mission213, R.string.mission213_description, R.string.mission213_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION214(R.string.mission214, R.string.mission214_description, R.string.mission214_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION215(R.string.mission215, R.string.mission215_description, R.string.mission215_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION216(R.string.mission216, R.string.mission216_description, R.string.mission216_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION217(R.string.mission217, R.string.mission217_description, R.string.mission217_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION218(R.string.mission218, R.string.mission218_description, R.string.mission218_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 31;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION219(R.string.mission219, R.string.mission219_description, R.string.mission219_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION220(R.string.mission220, R.string.mission220_description, R.string.mission220_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION221(R.string.mission221, R.string.mission221_description, R.string.mission221_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION222(R.string.mission222, R.string.mission222_description, R.string.mission222_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION223(R.string.mission223, R.string.mission223_description, R.string.mission223_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION224(R.string.mission224, R.string.mission224_description, R.string.mission224_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION225(R.string.mission225, R.string.mission225_description, R.string.mission225_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 32;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION226(R.string.mission226, R.string.mission226_description, R.string.mission226_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION227(R.string.mission227, R.string.mission227_description, R.string.mission227_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION228(R.string.mission228, R.string.mission228_description, R.string.mission228_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION229(R.string.mission229, R.string.mission229_description, R.string.mission229_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION230(R.string.mission230, R.string.mission230_description, R.string.mission230_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION231(R.string.mission231, R.string.mission231_description, R.string.mission231_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION232(R.string.mission232, R.string.mission232_description, R.string.mission232_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 33;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION233(R.string.mission233, R.string.mission233_description, R.string.mission233_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION234(R.string.mission234, R.string.mission234_description, R.string.mission234_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION235(R.string.mission235, R.string.mission235_description, R.string.mission235_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION236(R.string.mission236, R.string.mission236_description, R.string.mission236_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION237(R.string.mission237, R.string.mission237_description, R.string.mission237_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION238(R.string.mission238, R.string.mission238_description, R.string.mission238_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 300;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 3;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_B), MISSION239(R.string.mission239, R.string.mission239_description, R.string.mission239_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION240(R.string.mission240, R.string.mission240_description, R.string.mission240_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION241(R.string.mission241, R.string.mission241_description, R.string.mission241_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION242(R.string.mission242, R.string.mission242_description, R.string.mission242_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION243(R.string.mission243, R.string.mission243_description, R.string.mission243_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION244(R.string.mission244, R.string.mission244_description, R.string.mission244_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION245(R.string.mission245, R.string.mission245_description, R.string.mission245_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION246(R.string.mission246, R.string.mission246_description, R.string.mission246_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION247(R.string.mission247, R.string.mission247_description, R.string.mission247_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION248(R.string.mission248, R.string.mission248_description, R.string.mission248_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION249(R.string.mission249, R.string.mission249_description, R.string.mission249_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION250(R.string.mission250, R.string.mission250_description, R.string.mission250_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION251(R.string.mission251, R.string.mission251_description, R.string.mission251_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION252(R.string.mission252, R.string.mission252_description, R.string.mission252_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION253(R.string.mission253, R.string.mission253_description, R.string.mission253_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION254(R.string.mission254, R.string.mission254_description, R.string.mission254_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION255(R.string.mission255, R.string.mission255_description, R.string.mission255_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION256(R.string.mission256, R.string.mission256_description, R.string.mission256_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION257(R.string.mission257, R.string.mission257_description, R.string.mission257_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION258(R.string.mission258, R.string.mission258_description, R.string.mission258_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION259(R.string.mission259, R.string.mission259_description, R.string.mission259_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION260(R.string.mission260, R.string.mission260_description, R.string.mission260_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION261(R.string.mission261, R.string.mission261_description, R.string.mission261_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION262(R.string.mission262, R.string.mission262_description, R.string.mission262_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION263(R.string.mission263, R.string.mission263_description, R.string.mission263_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION264(R.string.mission264, R.string.mission264_description, R.string.mission264_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION265(R.string.mission265, R.string.mission265_description, R.string.mission265_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION266(R.string.mission266, R.string.mission266_description, R.string.mission266_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION267(R.string.mission267, R.string.mission267_description, R.string.mission267_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION268(R.string.mission268, R.string.mission268_description, R.string.mission268_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION269(R.string.mission269, R.string.mission269_description, R.string.mission269_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION270(R.string.mission270, R.string.mission270_description, R.string.mission270_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A), MISSION271(R.string.mission271, R.string.mission271_description, R.string.mission271_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION272(R.string.mission272, R.string.mission272_description, R.string.mission272_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION273(R.string.mission273, R.string.mission273_description, R.string.mission273_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION274(R.string.mission274, R.string.mission274_description, R.string.mission274_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION275(R.string.mission275, R.string.mission275_description, R.string.mission275_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION276(R.string.mission276, R.string.mission276_description, R.string.mission276_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION277(R.string.mission277, R.string.mission277_description, R.string.mission277_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION278(R.string.mission278, R.string.mission278_description, R.string.mission278_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION279(R.string.mission279, R.string.mission279_description, R.string.mission279_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION280(R.string.mission280, R.string.mission280_description, R.string.mission280_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION281(R.string.mission281, R.string.mission281_description, R.string.mission281_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION282(R.string.mission282, R.string.mission282_description, R.string.mission282_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION283(R.string.mission283, R.string.mission283_description, R.string.mission283_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION284(R.string.mission284, R.string.mission284_description, R.string.mission284_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION285(R.string.mission285, R.string.mission285_description, R.string.mission285_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION286(R.string.mission286, R.string.mission286_description, R.string.mission286_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION287(R.string.mission287, R.string.mission287_description, R.string.mission287_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION288(R.string.mission288, R.string.mission288_description, R.string.mission288_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION289(R.string.mission289, R.string.mission289_description, R.string.mission289_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION290(R.string.mission290, R.string.mission290_description, R.string.mission290_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION291(R.string.mission291, R.string.mission291_description, R.string.mission291_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION292(R.string.mission292, R.string.mission292_description, R.string.mission292_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION293(R.string.mission293, R.string.mission293_description, R.string.mission293_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION294(R.string.mission294, R.string.mission294_description, R.string.mission294_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION295(R.string.mission295, R.string.mission295_description, R.string.mission295_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION296(R.string.mission296, R.string.mission296_description, R.string.mission296_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION297(R.string.mission297, R.string.mission297_description, R.string.mission297_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 350;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 4;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 35;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_A),
    MISSION298(R.string.mission298, R.string.mission298_description, R.string.mission298_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION299(R.string.mission299, R.string.mission299_description, R.string.mission299_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION300(R.string.mission300, R.string.mission300_description, R.string.mission300_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION301(R.string.mission301, R.string.mission301_description, R.string.mission301_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION302(R.string.mission302, R.string.mission302_description, R.string.mission302_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION303(R.string.mission303, R.string.mission303_description, R.string.mission303_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION304(R.string.mission304, R.string.mission304_description, R.string.mission304_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION305(R.string.mission305, R.string.mission305_description, R.string.mission305_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION306(R.string.mission306, R.string.mission306_description, R.string.mission306_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION307(R.string.mission307, R.string.mission307_description, R.string.mission307_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION308(R.string.mission308, R.string.mission308_description, R.string.mission308_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION309(R.string.mission309, R.string.mission309_description, R.string.mission309_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION310(R.string.mission310, R.string.mission310_description, R.string.mission310_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION311(R.string.mission311, R.string.mission311_description, R.string.mission311_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION312(R.string.mission312, R.string.mission312_description, R.string.mission312_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION313(R.string.mission313, R.string.mission313_description, R.string.mission313_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S), MISSION314(R.string.mission314, R.string.mission314_description, R.string.mission314_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION315(R.string.mission315, R.string.mission315_description, R.string.mission315_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION316(R.string.mission316, R.string.mission316_description, R.string.mission316_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION317(R.string.mission317, R.string.mission317_description, R.string.mission317_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION318(R.string.mission318, R.string.mission318_description, R.string.mission318_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION319(R.string.mission319, R.string.mission319_description, R.string.mission319_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION320(R.string.mission320, R.string.mission320_description, R.string.mission320_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION321(R.string.mission321, R.string.mission321_description, R.string.mission321_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION322(R.string.mission322, R.string.mission322_description, R.string.mission322_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION323(R.string.mission323, R.string.mission323_description, R.string.mission323_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION324(R.string.mission324, R.string.mission324_description, R.string.mission324_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION325(R.string.mission325, R.string.mission325_description, R.string.mission325_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION326(R.string.mission326, R.string.mission326_description, R.string.mission326_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION327(R.string.mission327, R.string.mission327_description, R.string.mission327_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION328(R.string.mission328, R.string.mission328_description, R.string.mission328_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION329(R.string.mission329, R.string.mission329_description, R.string.mission329_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION330(R.string.mission330, R.string.mission330_description, R.string.mission330_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION331(R.string.mission331, R.string.mission331_description, R.string.mission331_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION332(R.string.mission332, R.string.mission332_description, R.string.mission332_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION333(R.string.mission333, R.string.mission333_description, R.string.mission333_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION334(R.string.mission334, R.string.mission334_description, R.string.mission334_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION335(R.string.mission335, R.string.mission335_description, R.string.mission335_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION336(R.string.mission336, R.string.mission336_description, R.string.mission336_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S), MISSION337(R.string.mission337, R.string.mission337_description, R.string.mission337_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION338(R.string.mission338, R.string.mission338_description, R.string.mission338_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION339(R.string.mission339, R.string.mission339_description, R.string.mission339_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION340(R.string.mission340, R.string.mission340_description, R.string.mission340_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION341(R.string.mission341, R.string.mission341_description, R.string.mission341_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION342(R.string.mission342, R.string.mission342_description, R.string.mission342_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION343(R.string.mission343, R.string.mission343_description, R.string.mission343_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION344(R.string.mission344, R.string.mission344_description, R.string.mission344_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION345(R.string.mission345, R.string.mission345_description, R.string.mission345_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION346(R.string.mission346, R.string.mission346_description, R.string.mission346_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION347(R.string.mission347, R.string.mission347_description, R.string.mission347_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION348(R.string.mission348, R.string.mission348_description, R.string.mission348_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION349(R.string.mission349, R.string.mission349_description, R.string.mission349_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION350(R.string.mission350, R.string.mission350_description, R.string.mission350_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION351(R.string.mission351, R.string.mission351_description, R.string.mission351_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION352(R.string.mission352, R.string.mission352_description, R.string.mission352_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION353(R.string.mission353, R.string.mission353_description, R.string.mission353_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S), MISSION354(R.string.mission354, R.string.mission354_description, R.string.mission354_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S), MISSION355(R.string.mission355, R.string.mission355_description, R.string.mission355_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION356(R.string.mission356, R.string.mission356_description, R.string.mission356_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION357(R.string.mission357, R.string.mission357_description, R.string.mission357_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION358(R.string.mission358, R.string.mission358_description, R.string.mission358_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION359(R.string.mission359, R.string.mission359_description, R.string.mission359_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION360(R.string.mission360, R.string.mission360_description, R.string.mission360_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION361(R.string.mission361, R.string.mission361_description, R.string.mission361_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION362(R.string.mission362, R.string.mission362_description, R.string.mission362_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 5;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 45;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION363(R.string.mission363, R.string.mission363_description, R.string.mission363_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION364(R.string.mission364, R.string.mission364_description, R.string.mission364_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION365(R.string.mission365, R.string.mission365_description, R.string.mission365_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION366(R.string.mission366, R.string.mission366_description, R.string.mission366_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION367(R.string.mission367, R.string.mission367_description, R.string.mission367_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }),
            Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION368(R.string.mission368, R.string.mission368_description, R.string.mission368_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }), Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION369(R.string.mission369, R.string.mission369_description, R.string.mission369_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }), Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION370(R.string.mission370, R.string.mission370_description, R.string.mission370_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }), Mission.Type.TIME, Mission.Rank.RANK_S),
    MISSION371(R.string.mission371, R.string.mission371_description, R.string.mission371_description,
            Arrays.asList(new Reward() {
                @Override
                public int value() {
                    return 400;
                }

                @Override
                public void receive() {
                    CharOn.character.addRyous(value());
                }

                @Override
                public CharSequence toString(Context context) {
                    return context.getString(R.string.ry, value());
                }
            }, new Reward() {
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
            }),
            Arrays.asList(new Requirement() {
                              @Override
                              public int getValue() {
                                  return 6;
                              }

                              @Override
                              public boolean check() {
                                  return CharOn.character.getGraduationId() >= getValue();
                              }

                              @Override
                              public String toString(Context context) {
                                  return context.getString(GraduationUtils.getName(getValue()));
                              }
                          },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 55;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getLevel() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return "Lvl. " + getValue();
                        }
                    }), Mission.Type.TIME, Mission.Rank.RANK_S);

    @StringRes
    public final int title;

    @StringRes
    public final int description;

    @StringRes
    public final int msgFinished;

    public final List<Reward> rewards;
    public final List<Requirement> requirements;
    public final Mission.Type type;
    public final Mission.Rank rank;

    MissionInfo(@StringRes int title, @StringRes int description, @StringRes int msgFinished,
                List<Reward> rewards, List<Requirement> requirements, Mission.Type type,
                Mission.Rank rank) {
        this.title = title;
        this.description = description;
        this.msgFinished = msgFinished;
        this.rewards = rewards;
        this.requirements = requirements;
        this.type = type;
        this.rank = rank;
    }

    public String getRewards(Context context) {
        StringBuilder builder = new StringBuilder();

        final int TOTAL_REWARDS = rewards.size();

        for (int i = 0; i < TOTAL_REWARDS; i++) {
            builder.append(rewards.get(i).toString(context));

            if (i < TOTAL_REWARDS - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    public String getRequirements(Context context) {
        StringBuilder builder = new StringBuilder();

        final int TOTAL_REQUIREMENTS = requirements.size();

        for (int i = 0; i < TOTAL_REQUIREMENTS; i++) {
            builder.append(requirements.get(i).toString(context));

            if (i < TOTAL_REQUIREMENTS - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
