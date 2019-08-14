import java.util.concurrent.TimeUnit;


abstract class Weapon {
    private int timeToReload = 3;//Время перезарядки
    private Damage projectile;//Создаем экземляр класса Damage, которым мы будем наносить урон

    public int getTimeToReload() {
        return timeToReload;
    }

    public void setTimeToReload(int value) {
        timeToReload = value;
    }

    public Weapon(int type) {
        switch (type) {
            case 1:
                projectile = new FireDamage();
                break;
            case 2:
                projectile = new FrozenDamage();
                break;
            default:
                projectile = new PhysicalDamage();
                break;
        }
    }

    public void fire() throws InterruptedException {
        projectile.hit();//Сначала вызываем функцию hit(), которая находится в родительском классе Damage
        reload();
    }

    public void reload() throws InterruptedException {
        System.out.println("Перезарядка.. Необходимо подождать " + timeToReload + " секунд");//Сообщаем, что начали перезарядку
        TimeUnit.SECONDS.sleep(timeToReload);//Ждем 3 секунды
    }
}

class Sword extends Weapon {
    public Sword(int type) {
        super(type); //Вызываем конструктор родительского класса
        setTimeToReload(4);
    }

    @Override
    public void reload() throws InterruptedException {
        System.out.println("Заносим меч, необходимо подождать " + getTimeToReload() + " секунды");//Сообщаем, что сейчас будем заносить меч
        TimeUnit.SECONDS.sleep(getTimeToReload());//Ждем, пока заносится меч
    }
}

class BowWeapon extends Weapon {
    public BowWeapon(int type) {
        super(type);
        setTimeToReload(10);
    }

    @Override
    public void reload() throws InterruptedException {
        System.out.println("Заносим стрелу, необходимо подождать " + getTimeToReload() + " секунд");//Сообщаем, что сейчас будем заносить стрелу
        TimeUnit.SECONDS.sleep(getTimeToReload());//Ждем, пока заносится стрела
    }
}
