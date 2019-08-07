package ThreadLocalTest;

/**
 * @ClassName RunableBank
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/23  3:18 PM
 * @Version 1.0
 */
public class RunableBank implements Runnable {
    Bank bank;

    public RunableBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run(){
        for (int i=0;i<10;i++){
            bank.setThreadLocal();
            bank.OutThreadLocal();
        }
    }
}
