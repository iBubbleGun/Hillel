package edu.hillel.homework.lesson17.petrol_station;

import com.google.common.util.concurrent.AtomicDouble;
import edu.hillel.homework.lesson17.petrol_station.car.Car;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PetrolStation {

    private static final int MAXIMUM_THREADS_ALLOWED = 3;
    private final AtomicDouble amount;
    private final ExecutorService executor;

    public PetrolStation(double initialFuelAmount) {
        this.amount = new AtomicDouble(initialFuelAmount);
        ThreadFactory threadFactory = new ThreadFactory() {
            private int pumpNumber = 1;

            @Override
            public @NotNull Thread newThread(@NotNull Runnable r) {
                return new Thread(r, Integer.toString(pumpNumber++));
            }
        };
        this.executor = Executors.newFixedThreadPool(MAXIMUM_THREADS_ALLOWED, threadFactory);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double newAmount) {
        this.amount.set(newAmount);
    }

    public void addAmount(double amount) {
        this.amount.addAndGet(amount);
    }

    public void doRefuel(Car car, double fuelAmount) {
        executor.execute(() -> {
            if (amount.updateAndGet(currentAmount -> currentAmount - fuelAmount) >= 0.0) {
                System.out.println(
                        "Refueled " + fuelAmount + " liters petrol for \"" +
                                car.getCarBrand() + "\" government number \"" + car.getCarNumber() +
                                "\" (working gas pump #" + Thread.currentThread().getName() + ")."
                );
                try {
                    Thread.sleep(getLattency() * 1_000); // simulate a delay in refueling time
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                /*System.out.println("(!) Debug: " +
                        "Gas pump #" + Thread.currentThread().getName() +
                        " finished refueling \"" + car.getCarBrand() + "\" " +
                        "government number \"" + car.getCarNumber() + "\" (!)");*/
            } else {
                addAmount(fuelAmount);
                System.out.println("Refueling no longer possible for \"" + car.getCarBrand() + "\" " +
                        "government number \"" + car.getCarNumber() + "\". " +
                        "Current fuel balance (" + getAmount() + " liters) less than " + fuelAmount + " liters!");
            }
        });
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)) {
                System.out.println("Done!\n------\n" +
                        "Current fuel balance at the station: " + amount.get() + " liters.");
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    private long getLattency() {
        int min = 3;
        int max = 10;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
