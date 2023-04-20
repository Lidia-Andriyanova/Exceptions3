public class Main {
    public static void main(String[] args) {
        inputFloat();
    }

    public static void inputFloat() {
        try {
            // Размер не 4x4
            String[][] myArray1 = {
                    {"5", "7", "9", "10"},
                    {"3", "9", "2", "8"},
                    {"4", "8", "9", "5"},
                    {"8", "6", "7"},
            };
            System.out.printf("Сумма элементов массива: %d\n", myArraySum(myArray1));

            // Некорректное значение в ячейке
//            String[][] myArray2 = {
//                    {"5", "7", "9", "10"},
//                    {"3", "9", "2", "8"},
//                    {"4", "test", "9", "5"},
//                    {"8", "6", "7", "6"},
//            };
//            System.out.printf("Сумма элементов массива: %d\n", myArraySum(myArray2));

           // Сумма элементов массива
//           String[][] myArray3 = {
//                   {"5", "7", "9", "10"},
//                   {"3", "9", "2", "8"},
//                   {"4", "8", "9", "5"},
//                   {"8", "6", "7", "8"},
//           };
//          System.out.printf("Сумма элементов массива: %d\n", myArraySum(myArray3));


        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    public static int myArraySum(String[][] myArray) {
        isSizeOfArray(myArray, 4);
        isIntInArray(myArray);

        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                sum += Integer.parseInt(myArray[i][j]);
            }
        }
        return sum;
    }

    public static void isSizeOfArray(String[][] myArray, int size) {
        if (myArray == null || myArray.length != size) {
            throw new MyArraySizeException(size);
        }
        for (int i = 0; i < myArray.length; i++) {
            if  (myArray[i] == null || myArray[i].length != size) {
                throw new MyArraySizeException(size);
            }
        }
    }

    public static void isIntInArray(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (myArray[i][j] == null) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
                try {
                    Integer.parseInt(myArray[i][j]);
                }  catch  (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
    }

    public static class MyArraySizeException extends RuntimeException {
        public MyArraySizeException(int size) {
            super(String.format("Массив не размера %dx%d", size, size));
        }
    }

    public static class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(int row, int col) {
            super(String.format("Некорректное значение в ячейке: строка %d, столбец %d", row, col));
        }
    }
}