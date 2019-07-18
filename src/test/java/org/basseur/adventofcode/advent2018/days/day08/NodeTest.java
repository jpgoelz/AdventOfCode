package org.basseur.adventofcode.advent2018.days.day08;

import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NodeTest {

    @MockBean
    private FileReaders fileReaders;
    private Node node;
    private Integer[] treeData = {2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2};

    @Before
    public void setUp() {
        node = new Node(treeData);
    }

    @Test
    public void getSumOfMetadata() {
        int expectedResult = 138;
        int actualResult = node.getSumOfMetadata();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNodeValue() {
        int expectedResult = 66;
        int actualResult = node.getNodeValue();

        Assert.assertEquals(expectedResult, actualResult);
    }
}