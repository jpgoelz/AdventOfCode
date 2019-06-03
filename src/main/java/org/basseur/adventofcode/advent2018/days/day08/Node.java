package org.basseur.adventofcode.advent2018.days.day08;

import java.util.Arrays;

public class Node {
    /** The length of the header the containing amount of child nodes and the length of metadata */
    private static final int headerLength = 2;
    /** The metadata of this node */
    private Integer[] metadata;
    /** The child nodes of this node */
    private Node[] childNodes;

    /**
     * The constructor parses the nodes array and instantiates its own child nodes, while also storing the meta data
     *
     * @param nodes the array of nodes to be parsed
     */
    Node(Integer[] nodes) {
        int numberOfChildNodes = nodes[0];
        int metadataLength = nodes[1];

        childNodes = new Node[numberOfChildNodes];
        int currentChildNodeStart = headerLength;

        for (int i = 0; i < numberOfChildNodes; i++) {
            childNodes[i] = new Node(Arrays.copyOfRange(nodes, currentChildNodeStart, nodes.length));

            currentChildNodeStart += childNodes[i].getLength();
        }

        metadata = new Integer[metadataLength];

        int metadataStart = getLength() - metadataLength;

        System.arraycopy(nodes, metadataStart, metadata, 0, metadataLength);
    }

    /**
     * Determines and returns the length of this node recursively.
     *
     * @return the length of this node
     */
    private int getLength() {
        int length = headerLength + metadata.length;
        for (Node childNode : childNodes) {
            length += childNode.getLength();
        }
        return length;
    }

    /**
     * Primary method for Day 8, Part 1.
     * <p>
     * Calculates the sum of all metadata entries. For this purpose it first calculates the sum of the
     * metadata of this node and then calls this method for each of the child nodes recursively. The values
     * are added up and returned.
     *
     * @return the sum of all metadata of this and the child nodes
     */
    public int getSumOfMetadata() {
        int sum = 0;
        for (int metadatum : metadata) {
            sum += metadatum;
        }
        for (Node childNode : childNodes) {
            sum += childNode.getSumOfMetadata();
        }
        return sum;
    }

    /**
     * Primary method for Day 8, Part 2.
     * <p>
     * Determines the value of this node. If it has no child nodes, the value is the sum of this nodes metadata.
     * If it has children, the value is calculated the following way:
     * Each metadata entry represents a reference to the child nodes of this node (e.g. 1 is the first child node).
     * The value of the referenced child node is obtained by calling this method of that child node. This way, all
     * the values of the child nodes are added up recursively and returned.
     *
     * @return the value of this node
     */
    public int getNodeValue() {
        int value = 0;
        if (childNodes.length == 0) {
            for (int metadatum : metadata) {
                value += metadatum;
            }
        } else {
            for (int metadatum : metadata) {
                if (metadatum <= childNodes.length) {
                    value += childNodes[metadatum - 1].getNodeValue();
                }
            }
        }
        return value;
    }
}
