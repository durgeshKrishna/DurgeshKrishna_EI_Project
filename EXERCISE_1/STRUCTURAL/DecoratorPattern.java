public class DecoratorPattern{

    interface Tea {
        String getDescription();
        double getCost();
    }

    static class SimpleTea implements Tea {
        public String getDescription() {
            return "Simple Tea";
        }

        public double getCost() {
            return 20.0;
        }
    }

    static abstract class TeaDecorator implements Tea {
        protected Tea tea;

        public TeaDecorator(Tea tea) {
            this.tea = tea;
        }

        public String getDescription() {
            return tea.getDescription();
        }

        public double getCost() {
            return tea.getCost();
        }
    }

    static class MasalaTeaDecorator extends TeaDecorator {
        public MasalaTeaDecorator(Tea tea) {
            super(tea);
        }

        public String getDescription() {
            return tea.getDescription() + ", Masala";
        }

        public double getCost() {
            return tea.getCost() + 5.0;
        }
    }

    static class GingerTeaDecorator extends TeaDecorator {
        public GingerTeaDecorator(Tea tea) {
            super(tea);
        }

        public String getDescription() {
            return tea.getDescription() + ", Ginger";
        }

        public double getCost() {
            return tea.getCost() + 4.0;
        }
    }

    static class CardamomTeaDecorator extends TeaDecorator {
        public CardamomTeaDecorator(Tea tea) {
            super(tea);
        }

        public String getDescription() {
            return tea.getDescription() + ", Cardamom";
        }

        public double getCost() {
            return tea.getCost() + 6.0;
        }
    }

    public static void main(String[] args) {
        Tea tea = new SimpleTea();
        System.out.println(tea.getDescription() + " Rs " + tea.getCost());

        tea = new MasalaTeaDecorator(tea);
        System.out.println(tea.getDescription() + " Rs " + tea.getCost());

        tea = new GingerTeaDecorator(tea);
        System.out.println(tea.getDescription() + " Rs " + tea.getCost());

        tea = new CardamomTeaDecorator(tea);
        System.out.println(tea.getDescription() + " Rs " + tea.getCost());
    }
}
