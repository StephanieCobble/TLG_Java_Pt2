package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findRockForLess_shouldReturnPopulatedCollection() {
        Collection<MusicItem> items = catalog.findRockForLess(14.0);
        assertEquals(3, items.size());
        List<MusicItem> itemsList = new ArrayList<>(items);
        assertEquals(Long.valueOf(8L), itemsList.get(0).getId());
        assertEquals(Long.valueOf(18L), itemsList.get(1).getId());
        assertEquals(Long.valueOf(17L), itemsList.get(2).getId());
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, items.size());
        List<MusicItem> itemsList = new ArrayList<>(items);
        assertEquals(Long.valueOf(1L), itemsList.get(0).getId());
        assertEquals(Long.valueOf(2L), itemsList.get(1).getId());
        assertEquals(Long.valueOf(6L), itemsList.get(2).getId());
        assertEquals(Long.valueOf(14L), itemsList.get(3).getId());
    }

    @Test
    public void findSelfTitled_shouldReturnPopulatedCollection() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        assertEquals(2, items.size());
        List<MusicItem> itemsList = new ArrayList<>(items);
        assertEquals(Long.valueOf(6L), itemsList.get(0).getId());
        assertEquals(Long.valueOf(7L), itemsList.get(1).getId());
    }

    @Test
    public void findById_shouldReturnMusicItem_whenIdFound() {
        MusicItem item = catalog.findById(5L);
        assertEquals(Long.valueOf(5), item.getId()); // OR ⤵️
//        assertEquals(1L, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(-1L);
        assertNull(item);
    }
}