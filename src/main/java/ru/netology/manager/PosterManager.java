package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {

    private int resultLength;
    private int maxLimit = 10;

    public PosterManager() {
    }

    public PosterManager(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    private PosterItem[] items = new PosterItem[0];

    public void save(PosterItem item) {
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] findAll() {
        return items;
    }

    public PosterItem[] findLast() {
        if (findAll().length >= maxLimit) {
            resultLength = maxLimit;
        }
        if (findAll().length < maxLimit) {
            resultLength = findAll().length;
        }
        PosterItem[] posterItems = findAll();
        PosterItem[] result = new PosterItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = posterItems.length - i - 1;
            result[i] = posterItems[index];
        }
        return result;

    }


}
