package HomeWork5;

import java.util.ArrayList;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        ManagerServer managerServer = new ManagerServer();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Развернуть новый сервер (пользователь вводит данные).");
            System.out.println("[2] Показать список всех активных серверов и их ОС.");
            System.out.println("[3] Рассчитать общий счет за месяц (сумма стоимостей всех серверов в списке).");
            System.out.println("[0] Выйти из панели управления.");
            int res = sc.nextInt();
            sc.nextLine();
            switch (res) {
                case 1:
                    System.out.println("Введите  IP-address сервера: ");
                    String result = sc.nextLine();
                    System.out.println("Введите память выделенную на сервер: ");
                    int resultMb  = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Введите операционную систему: ");
                    String operationSystemResult = sc.nextLine();
                    OperatingSystem operatingSystem = OperatingSystem.valueOf(operationSystemResult.toUpperCase());
                    System.out.println("Выберите какой сервер будем создавать: 1 - DataBaseServer | 2 - WebServer.");
                    int resultServer = sc.nextInt();
                    sc.nextLine();
                    if (resultServer == 1){
                        ServerAcc serverAcc1 = new DatabaseServer(resultMb,result,operatingSystem);
                        managerServer.addServer(serverAcc1);
                    } else {
                        ServerAcc serverAcc2 = new WebServer(resultMb,result,operatingSystem);
                        managerServer.addServer(serverAcc2);
                    }
                    System.out.println("Сервер успешно добавлен.");
                    break;
                case 2:
                    System.out.println("---Загружаем сервера---");
                    managerServer.checkServer();
                    break;
                case 3:
                    System.out.println("Укажите процент для расчета стоимости:");
                    int currentProcent = sc.nextInt();
                    sc.nextLine();
                    managerServer.sumServer(currentProcent);
                    break;
                case 0:
                    System.out.println("Выходим из меню...");
                    System.exit(0);
            }
        }

    }
    }

    class ManagerServer {
        ArrayList<ServerAcc> server = new ArrayList<>();
        public void addServer(ServerAcc newServer) {
            server.add(newServer);


        }
        public void checkServer(){
            if (server.isEmpty()){
                System.out.println("Список серверов пуст.");
                return;
            }
            for (ServerAcc m: server){
                System.out.println("IP-address сервера: " + m.getIpAddress() + " Память: " + m.getRamMb() + " Операционная система: " + m.getOperatingSystem());
            }
        }
        public void sumServer( int currentProcent){
            int totalSum = 0;
            for (ServerAcc s:server){
           totalSum+=s.billableCount(currentProcent);
            } System.out.println("Общий счет за месяц: " + totalSum);
        }
    }

    abstract class ServerAcc implements Billable {
        private String ipAddress;
        private int ramMb;
        private OperatingSystem operatingSystem;

        public ServerAcc(int ramMb, String ipAddress, OperatingSystem operatingSystem) {
            setRamMb(ramMb);
            setIpAddress(ipAddress);
            this.operatingSystem = operatingSystem;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            if (ipAddress == null || ipAddress.trim().isEmpty()) {
                System.out.println("Ошибка. Ip адрес не может быть пустым.");
                return;
            }
            this.ipAddress = ipAddress;

        }

        public int getRamMb() {
            return ramMb;
        }

        public void setRamMb(int ramMb) {
            if (ramMb < 512) {
                throw new IllegalArgumentException("Недостаточно памяти для запуска. В запасе нужно иметь больше 512мб.");
            }
            this.ramMb = ramMb;
        }

        public OperatingSystem getOperatingSystem() {
            return operatingSystem;
        }
        public abstract int billableCount(int procent);
    }

    interface Billable {
        public int billableCount(int procent);
    }

    enum OperatingSystem {
        LINUX,
        WINDOWS
    }

    class DatabaseServer extends ServerAcc implements Billable {
        public DatabaseServer(int ramMb, String ipAddress, OperatingSystem operatingSystem) {
            super(ramMb, ipAddress, operatingSystem);
        }

        @Override
        public int billableCount(int procent) {
            int resultDataBase = getRamMb() * procent;
            return resultDataBase;
        }

    }

    class WebServer extends ServerAcc implements Billable {
        public WebServer(int ramMb, String ipAddress, OperatingSystem operatingSystem) {
            super(ramMb, ipAddress, operatingSystem);
        }

        @Override
        public int billableCount(int procent) {
            int resultWebServer = getRamMb() * 120;
            return resultWebServer;
        }
    }
