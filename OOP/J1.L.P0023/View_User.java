
public class View_User {

    Validation Validation = new Validation();
    Controller c = new Controller();
    public void CreatFruit() {
        //loop until user don't want to create fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!Validation.checkIdExist(c.getList_Fruit(), fruitId)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            c.getList_Fruit().add(new Fruit(fruitId, fruitName, price, quantity, origin));
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
}
