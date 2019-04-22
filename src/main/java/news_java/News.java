package news_java;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum News {
    POLITIC("human rights"),
    NO_POLITIC("");
    private final String word;

    public static News getWord(String word){
        return Arrays.stream(values()).filter(news -> news.getWord().equals(word))
                .findAny().orElse(NO_POLITIC);
    }
}
