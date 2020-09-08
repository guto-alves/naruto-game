package com.gutotech.narutogame.data.model;

import android.content.Context;

import com.gutotech.narutogame.R;

import java.util.Arrays;
import java.util.List;

public enum Graduation {
    ESTUDANTE(4000, null),
    GENIN(6000, Arrays.asList(
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
                    return context.getString(R.string.requires_you_need_to_be_level, getValue());
                }
            },
            new Requirement() {
                @Override
                public int getValue() {
                    return 3;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getResumeOfMissions().getTasks() >= getValue();
                }

                @Override
                public String toString(Context context) {
                    return context.getString(R.string.requires_initial_tasks);
                }
            },
            new Requirement() {
                @Override
                public int getValue() {
                    return 1;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getJutsus().size() > 4;
                }

                @Override
                public String toString(Context context) {
                    return context.getString(R.string.requires_learned_jutsus, getValue());
                }
            },
            new Requirement() {

                @Override
                public int getValue() {
                    return 1;
                }

                @Override
                public boolean check() {
                    return CharOn.character.getCombatOverview().getWinsNpc() >= getValue();
                }

                @Override
                public String toString(Context context) {
                    return context.getString(R.string.requires_wins_npc, getValue());
                }
            }
    )),
    CHUUNIN(8000,
            Arrays.asList(
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
                            return context.getString(R.string.requires_you_need_to_be_level, getValue());
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getResumeOfMissions().getRankD() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_missions_rank, getValue(), "D");
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 9;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getJutsus().size() > getValue() + 4;
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_learned_jutsus, getValue());
                        }
                    },
                    new Requirement() {

                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getCombatOverview().getWinsMapPvp() +
                                    CharOn.character.getCombatOverview().getWinsDojoPvp() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_wins_pvp, getValue());
                        }
                    }
            )),
    JOUNIN(10000,
            Arrays.asList(
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
                            return context.getString(R.string.requires_you_need_to_be_level, getValue());
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getResumeOfMissions().getRankC() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_missions_rank, getValue(), "C");
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 16;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getJutsus().size() > getValue() + 4;
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_learned_jutsus, getValue());
                        }
                    },
                    new Requirement() {

                        @Override
                        public int getValue() {
                            return 80;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getCombatOverview().getWinsMapPvp() +
                                    CharOn.character.getCombatOverview().getWinsDojoPvp() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_wins_pvp, getValue());
                        }
                    }
            )),
    ANBU(12000,
            Arrays.asList(
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
                            return context.getString(R.string.requires_you_need_to_be_level, getValue());
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getResumeOfMissions().getRankB() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_missions_rank, getValue(), "B");
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 22;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getJutsus().size() > getValue() + 4;
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_learned_jutsus, getValue());
                        }
                    },
                    new Requirement() {

                        @Override
                        public int getValue() {
                            return 170;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getCombatOverview().getWinsMapPvp() +
                                    CharOn.character.getCombatOverview().getWinsDojoPvp() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_wins_pvp, getValue());
                        }
                    }
            )),
    SANNIN(14000,
            Arrays.asList(
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
                            return context.getString(R.string.requires_you_need_to_be_level, getValue());
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getResumeOfMissions().getRankA() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_missions_rank, getValue(), "A");
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 28;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getJutsus().size() > getValue() + 4;
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_learned_jutsus, getValue());
                        }
                    },
                    new Requirement() {

                        @Override
                        public int getValue() {
                            return 240;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getCombatOverview().getWinsMapPvp() +
                                    CharOn.character.getCombatOverview().getWinsDojoPvp() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_wins_pvp, getValue());
                        }
                    }
            )),
    HERO(15000,
            Arrays.asList(
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
                            return context.getString(R.string.requires_you_need_to_be_level, getValue());
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 20;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getResumeOfMissions().getRankS() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_missions_rank, getValue(), "S");
                        }
                    },
                    new Requirement() {
                        @Override
                        public int getValue() {
                            return 34;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getJutsus().size() > getValue() + 4;
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_learned_jutsus, getValue());
                        }
                    },
                    new Requirement() {

                        @Override
                        public int getValue() {
                            return 480;
                        }

                        @Override
                        public boolean check() {
                            return CharOn.character.getCombatOverview().getWinsMapPvp() +
                                    CharOn.character.getCombatOverview().getWinsDojoPvp() >= getValue();
                        }

                        @Override
                        public String toString(Context context) {
                            return context.getString(R.string.requires_wins_pvp, getValue());
                        }
                    }
            ));

    public final int dailyTrainingLimit;
    public final List<Requirement> requirements;

    Graduation(int dailyTrainingLimit, List<Requirement> requirement) {
        this.dailyTrainingLimit = dailyTrainingLimit;
        this.requirements = requirement;
    }
}
