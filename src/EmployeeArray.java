public class EmployeeArray {

    private Employee[] array = new Employee[1];
    private int index = 0;

    public void add(Employee emp) {
        if (index == array.length) {
            Employee[] newArr = new Employee[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[index++] = emp;
    }

    public int getIndex() {
        return index;
    }

    public Employee getEmployeeByIndex(int x) {
        if (0 <= x && x < index) {
            return array[x];
        }
        return null;
    }

    public int indexOf(int id) {
        for (int i = 0; i < index; i++) {
            if (array[i].getId() == id)
                return i;
        }
        return -1;
    }

    public boolean contains(int id) {
        int index = indexOf(id);
        return index != -1;
    }

    public void remove(int id) {
        int ind = indexOf(id);
        if (ind != -1) {
            for (int i = ind; i < index - 1; i++)
                array[i] = array[i + 1];
            index--;
        }
    }

    public void print() {
        System.out.print("{ ");
        for (int i = 0; i < index; i++) {
            if (i != index - 1) {
                System.out.print(array[i] + " , ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("}");
    }

    public Employee getEmployeeById(int id) {
        if (contains(id)) {
            return array[indexOf(id)];
        }
        return null;
    }
}



