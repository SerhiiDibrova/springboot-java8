package hello.model;

import java.util.ArrayList;

public class Tuple {
    private ArrayList<Object> elements;

    public Tuple(Object... elements) {
        this.elements = new ArrayList<>();
        for (Object element : elements) {
            this.addElement(element);
        }
    }

    public void addElement(Object element) {
        if (element != null) {
            this.elements.add(element);
        } else {
            throw new NullPointerException("Element cannot be null");
        }
    }

    public ArrayList<Object> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        if (this.elements.isEmpty()) {
            return "()";
        } else {
            StringBuilder sb = new StringBuilder("(");
            for (int i = 0; i < this.elements.size(); i++) {
                sb.append(this.elements.get(i));
                if (i < this.elements.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }
}