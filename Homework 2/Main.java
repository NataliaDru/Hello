import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Выберите тип урона для орудий:\n1 - FireDamage\n2 - FrozenDamage\n3 - PhysicalDamage");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();

        Sword sword = new Sword(type);
        for (int i = 0; i < 2; i++)
            sword.fire();//Вызываем 2 раз функцию fire()

        BowWeapon bow = new BowWeapon(type);//Создаем экземпляр класса BowWeapon
        for (int i = 0; i < 2; i++)
            bow.fire();//Вызываем 2 раза функцию fire
    }

    @Test
    public void fireDamage() {
        FireDamage damage = new FireDamage();

        int expected = 150;

        int actual = damage.hit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void frozenDamage() {
        FrozenDamage damage = new FrozenDamage();

        int expected = 100;

        int actual = damage.hit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void physicalDamage() {
        PhysicalDamage damage = new PhysicalDamage();

        int expected = 200;

        int actual = damage.hit();

        Assert.assertEquals(expected, actual);
    }

}