package main.algorithms.easy.datastructure;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenerateDocument {

    public boolean isPossibleToGenerateDoc(String characters, String document) {

        Map<Character, Integer> availableChars = getMapWithLettersCount(characters);
        Map<Character, Integer> documentRequiredChars = getMapWithLettersCount(document);
        for (var entry: documentRequiredChars.entrySet()) {
            Character requiredChar = entry.getKey();
            Integer count = entry.getValue();
            if (count > Optional.ofNullable(availableChars.get(requiredChar)).orElse(0)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getMapWithLettersCount(String characters) {
        return characters.chars()
                .mapToObj(charAsInt -> (char) charAsInt)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (k, v) -> v + 1));
    }
}
