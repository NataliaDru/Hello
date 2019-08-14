/*
Класс Damage - абстрактный. От абстрактных классов нельзя создавать экземпляры, это ограничение ООП.
Служит для того, чтоб выступать как родительский класс, от которого будут наследоваться другие классы.
Все свойства и методы у дочернего класса будут автоматически наследоваться от родительского
*/
abstract class Damage {
    private int damage = 100;//Урон в родительском класссе

    public int getDamage() {
        return damage;
    }

    /*
    Функция hit - функция нанесения урона. В родительском классе объявляется, в дочерних классах
    можно будет переопределить эту функцию(что и будет сделано ниже для всех дочерних классов)
    */
    int hit() {
        System.out.println(damage + " урона");
        return getDamage();
    }

}

/*
Класс FrozenDamage - класс замораживающего урона. Наследуется от абстрактного класса Damage(следовательно
мы унаследовали свойство damage и метод hit()
*/
class FrozenDamage extends Damage {
    int timeToFreeze = 5;//В дочернем классе создаем свойство timeToFreeze

    /*
    Переопределяем функцию hit(). Для этого указываем ключевое слово @Override и переписываем метод
    */
    @Override
    int hit() {
        System.out.println("Нанесено " + getDamage() + " урона, замораживание на " + timeToFreeze + " секунд");
        return getDamage();
    }
}

/*
Класс FireDamage - класс поджигающего урона. Наследуется от абстрактного класса Damage(следовательно
мы унаследовали свойство damage и метод hit()
*/
class FireDamage extends Damage {
    //Создаем два свойства в дочернем классе
    int timeToBurn = 10;//timeToBurn - время поджига
    int burnDamage = 5; //burnDamage - урон в секунду во время поджига

    /*
    Переопределяем функцию hit(). Для этого указываем ключевое слово @Override и переписываем метод
    */
    @Override
    int hit() {
        System.out.println("Нанесено " + getDamage() + " урона, поджог цели на " + timeToBurn + " секунд(каждую секунду будет нанесён урон в " + burnDamage + " единиц)");
        return getDamage() + (timeToBurn * burnDamage);
    }
}

class PhysicalDamage extends Damage {

    @Override
    int hit() {
        System.out.println("Нанесено " + (getDamage() * 2) + " урона!");
        return getDamage() * 2;
    }
}
