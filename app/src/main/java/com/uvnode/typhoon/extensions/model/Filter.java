package com.uvnode.typhoon.extensions.model;

public class Filter<T> {

    public String name;
    public T state;

    public Filter(String name, T state) {
        this.name = name;
        this.state = state;
    }

    class Text extends Filter<String> {
        public Text(String name, String state) {
            super(name, state);
        }
    }

    class CheckBox extends Filter<Boolean> {
        public CheckBox(String name, Boolean state) {
            super(name, state);
        }
    }

    class TriState extends Filter<Integer> {
        static final int STATE_IGNORE = 0;
        static final int STATE_INCLUDE = 1;
        static final int STATE_EXCLUDE = 2;

        public TriState(String name, Integer state) {
            super(name, state);
        }

        public boolean isIgnored() {
            return this.state == STATE_IGNORE;
        }

        public boolean isIncluded() {
            return this.state == STATE_INCLUDE;
        }

        public boolean isExcluded() {
            return this.state == STATE_EXCLUDE;
        }
    }
}
