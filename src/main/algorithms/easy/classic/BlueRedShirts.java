package main.algorithms.easy.classic;

import java.util.ArrayList;
import java.util.Collections;

public class BlueRedShirts {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights,
                               ArrayList<Integer> blueShirtHeights) {
        // Write your code here
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int indicator = 0;
        for (int i = 0; i < redShirtHeights.size(); i++) {

            if (redShirtHeights.get(i) > blueShirtHeights.get(i)) {
                indicator++;
            } else if (redShirtHeights.get(i) < blueShirtHeights.get(i)) {
                indicator--;
            }
        }
        return Math.abs(indicator) == redShirtHeights.size();
    }

}
