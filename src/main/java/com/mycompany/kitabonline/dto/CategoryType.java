package com.mycompany.kitabonline.dto;

public enum CategoryType {
    LITERATURE("Library"),
    COMIC("Comic"),
    CHILD_AND_YOUTH("Child and youth"),
    LESSON_TEST_BOOKS("Lesson test books"),
    EDUCATION_REFERENCE("Education reference"),
    PHILOSOPHY("Philosophy"),
    FOREiGN_LANGUAGE("Foreign language"),
    HOBBY("Hobby"),
    MYTH_LEGEND("Mth legend"),
    HUMOR("Humor"),
    PRESTIGE_BOOKS("Prestige books"),
    ART_DESIGN("Art design"),
    AUDIO_BOOKS("Audio books"),
    OTHER("Other"),
    SCIENCE("Science"),
    RESEARCH_HISTORY("Research history"),
    RELIGION("Religion");

    private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
