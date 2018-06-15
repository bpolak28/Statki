package pl.mojeprojekty.statki.form;

public class FieldsForm {

    private String[] positions;


    public FieldsForm() {
    }

    public FieldsForm(String[] positions) {
        this.positions = positions;
    }

    public String[] getPositions() {
        return positions;
    }

    public void setPositions(String[] positions) {
        this.positions = positions;
    }
}
