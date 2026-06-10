package HomeWork4;

import java.lang.annotation.Target;
import java.sql.SQLOutput;

public class DayOne {
    public static void main(String[] args) {

        Recipe recipe = new Recipe("Борщ", 90, 20);
        recipe.setCookingTimeMinutes(-90);
        System.out.println();


        ActivityLog activityLog = new ActivityLog("29.05.2026", 17000, 2600);
        activityLog.setDate(" ");
        activityLog.setCaloriesBurned(100000);
        activityLog.setStepsCount(90000000);
        System.out.println();

        Hero hero = new Hero("Subzero", 55, 90);
        hero.setHealth(-10);
        System.out.println(hero.getHealth());
        hero.setHealth(10000);
        System.out.println();

        ServerConfig serverConfig = new ServerConfig("1.1.1.1.2.0", 3098, 2);
        serverConfig.setMaxConnections(0);
        serverConfig.setIpAddress("1.1.1");
        serverConfig.setPort(1000);
        serverConfig.setPort(-10);

        Thermostat thermostat = new Thermostat("HEAT", 17.0);
        thermostat.setTargetTemp(7);
        thermostat.setMode("FREEZE");
        System.out.println(thermostat.getMode());


        CarSession carSession = new CarSession("а777мр", 10, true);
        carSession.setDoorsLocked(false);
        carSession.setFuelLevel(0);

        carSession.startEngine();


    }


    static class Recipe {
        private String name;
        private int cookingTimeMinutes;
        private int portions;

        Recipe(String name, int cookingTimeMinutes, int portions) {
            setName(name);
            setCookingTimeMinutes(cookingTimeMinutes);
            setPortions(portions);
        }

        public String getName() {
            return name;

        }

        public int getCookingTimeMinutes() {
            return cookingTimeMinutes;
        }

        public int getPortions() {
            return portions;
        }

        public void setName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Название блюдо не может быть пустым.");
            }
        }

        public void setPortions(int portions) {
            if (portions > 0 && portions < 50) {
                this.portions = portions;

            } else {
                System.out.println("Количество порций не должно превышать 50-ти и быть равным 0.");
            }

        }

        public void setCookingTimeMinutes(int cookingTimeMinutes) {
            if (cookingTimeMinutes > 0) {
                this.cookingTimeMinutes = cookingTimeMinutes;
            } else {
                System.out.println("Приготовление блюд не должно быть равным 0.");
            }
        }

    }

    static class ActivityLog {
        private String date;
        private int stepsCount;
        private double caloriesBurned;

        ActivityLog(String date, int stepsCount, double caloriesBurned) {
            setStepsCount(stepsCount);
            setDate(date);
            setCaloriesBurned(caloriesBurned);
        }

        public String getDate() {
            return date;
        }

        public int getStepsCount() {
            return stepsCount;
        }

        public double getCaloriesBurned() {
            return caloriesBurned;
        }

        public void setDate(String date) {
            if (date != null && !date.trim().isEmpty()) {
                this.date = date;
            } else {
                System.out.println("Ошибка. Дата не может быть пустой.");
            }
        }

        public void setStepsCount(int stepsCount) {
            if (stepsCount > 0 && stepsCount < 100000) {
                this.stepsCount = stepsCount;
            } else {
                System.out.println("Ошибка. Указано неверное количество шагов.");
            }
        }

        public void setCaloriesBurned(double caloriesBurned) {
            if (caloriesBurned > 0 && caloriesBurned < 15000) {
                this.caloriesBurned = caloriesBurned;

            } else {
                System.out.println("Ошибка. Указано неверное количество ккал.");
            }
        }

    }

    static class Hero {
        private String name;
        private int level;
        private int health;

        Hero(String name, int level, int health) {
            setName(name);
            setHealth(health);
            setLevel(level);
        }

        public String getName() {
            return name;

        }

        public int getLevel() {
            return level;
        }

        public int getHealth() {
            return health;
        }

        public void setName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Ошибка. Имя персонажа не может быть пустым.");
            }
        }

        public void setLevel(int level) {
            if (level >= 1 && level <= 100) {
                this.level = level;
            } else {
                System.out.println("Ошибка. Уровень персонажа указан не верно.");
            }
        }

        public void setHealth(int health) {
            if (health <= 0) {
                this.health = 0;
                System.out.println("Герой погиб.");
            } else if (health > 0 && health <= 100) {
                this.health = health;
            } else {
                System.out.println("Ошибка. Количество здоровья персонажа указано не верно. ");
            }
        }
    }

    static class ServerConfig {
        private String ipAddress;
        private int port;
        private int maxConnections;

        ServerConfig(String ipAddress, int port, int maxConnections) {
            setIpAddress(ipAddress);
            setPort(port);
            setMaxConnections(maxConnections);
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public int getPort() {
            return port;
        }

        public int getMaxConnections() {
            return maxConnections;
        }

        public void setIpAddress(String ipAddress) {
            if (ipAddress != null && !ipAddress.trim().isEmpty() && ipAddress.length() >= 7) {
                this.ipAddress = ipAddress;
            } else {
                System.out.println("Ошибка. Указан неверный IP адрес");
            }
        }

        public void setPort(int port) {
            if (port >= 1024 && port <= 65535) {
                this.port = port;
            } else if (port >= 0 && port <= 1023) {
                System.out.println("Ошибка. Порты от 0 до 1023 зарезервированы операционной системой ");

            } else {
                System.out.println("Вы ввели неверный порт");
            }
        }

        public void setMaxConnections(int maxConnections) {
            if (maxConnections >= 1 && maxConnections <= 10000) {
                this.maxConnections = maxConnections;
            } else {
                System.out.println("Ошибка. Количество подключений неверно.");
            }
        }


    }

    static class Thermostat {
        private String mode;
        private double targetTemp;

        Thermostat(String mode, double targetTemp) {
            setMode(mode);
            setTargetTemp(targetTemp);
        }

        public String getMode() {
            return mode;
        }

        public double getTargetTemp() {
            return targetTemp;
        }

        public void setMode(String mode) {
            if (mode != null && (mode.equals("HEAT") || mode.equals("COOL") || mode.equals("AUTO"))) {
                this.mode = mode;
            } else {
                System.out.println("Ошибка. Неверно указан режим работы.");
                this.mode = "AUTO";
            }
        }

        public void setTargetTemp(double targetTemp) {
            if (targetTemp >= 16 && targetTemp <= 30) {
                this.targetTemp = targetTemp;
            } else {
                System.out.println("Ошибка.Кондиционер может поддерживать температуру строго в диапазоне от 16.0 до 30.0 градусов. ");
            }
        }
    }

    static class CarSession {
        private String licensePlate;
        private int fuelLevel;
        private boolean doorsLocked;

        CarSession(String licensePlate, int fuelLevel, boolean doorsLocked) {
            setLicensePlate(licensePlate);
            setFuelLevel(fuelLevel);
            setDoorsLocked(doorsLocked);
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public int getFuelLevel() {
            return fuelLevel;
        }

        public boolean isDoorsLocked() {
            return doorsLocked;
        }

        public void setLicensePlate(String licensePlate) {
            if (licensePlate != null && !licensePlate.trim().isEmpty()) {
                this.licensePlate = licensePlate;
            } else {
                System.out.println("Ошибка. Номер машины указан неверно.");
            }
        }

        public void setFuelLevel(int fuelLevel) {
            if (fuelLevel >= 0 && fuelLevel <= 100) {
                this.fuelLevel = fuelLevel;
            } else {
                System.out.println("Ошибка. Уровень топлива указан неверно.");
            }
        }

        public void setDoorsLocked(boolean doorsLocked) {
            this.doorsLocked = doorsLocked;
        }

        public void startEngine() {
            if (fuelLevel == 0) {
                System.out.println("Бак пуст. Нужно заправить машину.");
            } else if (doorsLocked == false) {
                System.out.println("В целях безопасности сначала закройте двери!");
            } else if (fuelLevel > 0 && doorsLocked) {
                System.out.println("Двигатель запущен, приятной поездки.");

            } else {
                System.out.println("Указаны неверные параметры. Ошибка при запуске двигателя.");
            }
        }
    }
}