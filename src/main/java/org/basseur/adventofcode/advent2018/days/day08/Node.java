package org.basseur.adventofcode.advent2018.days.day08;

import java.util.Arrays;

public class Node {
    /** The length of the header the containing amount of sub nodes and the length of metadata */
    private static final int headerLength = 2;
    /** The metadata of this node */
    private int[] metadata;
    /** The sub nodes of this node */
    private Node[] subNodes;

    /**
     * The constructor parses the nodes array and instantiates its own child nodes, while also storing the meta data
     *
     * @param nodes the array of nodes to be parsed
     */
    Node(Integer[] nodes) {
        int amountOfSubNodes = nodes[0];
        int metadataLength = nodes[1];

        subNodes = new Node[amountOfSubNodes];
        int currentSubNodeStart = headerLength;

        for (int i = 0; i < amountOfSubNodes; i++) {
            subNodes[i] = new Node(Arrays.copyOfRange(nodes, currentSubNodeStart, nodes.length));

            currentSubNodeStart += subNodes[i].getLength();
        }

        metadata = new int[metadataLength];
        int metadataStart = getLength() - metadataLength;
        for (int i = 0; i < metadataLength; i++) {
            metadata[i] = nodes[i + metadataStart];
        }
    }

    /**
     * Determines and returns the length of this node recursively.
     *
     * @return the length of this node
     */
    private int getLength() {
        int length = headerLength + metadata.length;
        for (Node subNode : subNodes) {
            length += subNode.getLength();
        }
        return length;
    }

    /**
     * Primary method for Day 8, Part 1.
     * <p>
     * Calculates the sum of all metadata entries. For this purpose it first calculates the sum of the
     * metadata of this node and then calls this method for each of the sub nodes recursively. The values
     * are added up and returned.
     *
     * @return the sum of all metadata of this and the child nodes
     */
    public int getSumOfMetadata() {
        int sum = 0;
        for (int metadatum : metadata) {
            sum += metadatum;
        }
        for (Node subNode : subNodes) {
            sum += subNode.getSumOfMetadata();
        }
        return sum;
    }

    /**
     * Primary method for Day 8, Part 2.
     * <p>
     * Determines the value of this node. If it has no sub nodes, the value is the sum of this nodes metadata.
     * If it has children, the value is calculated the following way:
     * Each metadata entry represents a reference to the sub nodes of this node (e.g. 1 is the first sub node).
     * The value of the referenced sub node is obtained by calling this method of that sub node. This way, all
     * the values of the sub nodes are added up recursively and returned.
     *
     * @return the value of this node
     */
    public int getNodeValue() {
        int value = 0;
        if (subNodes.length == 0) {
            for (int metadatum : metadata) {
                value += metadatum;
            }
        } else {
            for (int metadatum : metadata) {
                if (metadatum <= subNodes.length) {
                    value += subNodes[metadatum - 1].getNodeValue();
                }
            }
        }
        return value;
    }
}
