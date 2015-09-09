/**
 * 
 */
package com.redhat.lightblue.client;

/**
 * @author bvulaj
 *
 */
public enum Operation {
    DELETE, FIND, INSERT, SAVE, UPDATE;

    public String toString() {
        return this.name().toLowerCase();
    }
}
