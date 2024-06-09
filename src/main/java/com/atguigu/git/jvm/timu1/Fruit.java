package com.atguigu.git.jvm.timu1;

public class Fruit {

    private static int x = 10;
    static BigWaterMelon bigWaterMelon_1 = new BigWaterMelon(x);

    private int y = 20;
    private BigWaterMelon bigWaterMelon_2 = new BigWaterMelon(y);

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        int z = 30;
        BigWaterMelon bigWaterMelon_3 = new BigWaterMelon(z);


        new Thread() {
            @Override
            public void run() {
                int k = 100;
                setWeight(k);
            }

            void setWeight(int waterMelonWeight) {
                fruit.bigWaterMelon_2.weight = waterMelonWeight;
                System.out.printf(fruit.bigWaterMelon_2.weight + "");
            }

        }.start();
    }
}

