 interface Innerinter {
    void getData();
    void deleteData();
    void updateData();
    void createData();
}
class sql implements Innerinter {
    public void getAny(){
        System.out.println("sql class");
    }

    @Override
    public void getData() {
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
    }

    @Override
    public void updateData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'updateData'");
    }

    @Override
    public void createData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'createData'");
    }
}
class readFile implements Innerinter{
    public void getAny(){

    }

    @Override
    public void getData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void deleteData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
    }

    @Override
    public void updateData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'updateData'");
    }

    @Override
    public void createData() {
         
        throw new UnsupportedOperationException("Unimplemented method 'createData'");
    }
}
public class inter extends sql{
    public void getAny(){

    }
}
