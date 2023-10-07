package edu.hillel.homework.lesson17.petrol_station;

import com.google.common.util.concurrent.AtomicDouble;
import edu.hillel.homework.lesson17.petrol_station.car.Car;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class PetrolStation {

    private static final int MAXIMUM_THREADS_ALLOWED = 3;
    private final AtomicDouble amount;
    private final ExecutorService executor;
    private final CountDownLatch latch;

    public PetrolStation(double initialFuelAmount, int totalCarsForRefuel) {
        this.amount = new AtomicDouble(initialFuelAmount);
        ThreadFactory threadFactory = new ThreadFactory() {
            private int pumpNumber = 1;

            @Override
            public @NotNull Thread newThread(@NotNull Runnable r) {
                return new Thread(r, Integer.toString(pumpNumber++));
            }
        };
        this.executor = Executors.newFixedThreadPool(MAXIMUM_THREADS_ALLOWED, threadFactory);
        this.latch = new CountDownLatch(totalCarsForRefuel);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.addAndGet(amount);
    }

    public void doRefuel(Car car, double fuelAmount) {
        executor.execute(() -> {
            double newAmount = amount.get() - fuelAmount;
            if (newAmount >= 0) {
                amount.set(newAmount);
                System.out.println(
                        "Refueled " + fuelAmount + " liters petrol for \"" +
                                car.getCarBrand() + "\" government number \"" + car.getCarNumber() +
                                "\" (is working gas pump number " + Thread.currentThread().getName() + ")."
                );
                try {
                    Thread.sleep((long) getLattency() * 1_000); // simulate a delay in refueling time
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            } else {
                System.out.println("Refueling no longer possible for \"" + car.getCarBrand() + "\" " +
                        "government number \"" + car.getCarNumber() + "\". " +
                        "Current fuel balance (" + amount.get() + " liters) less than " + fuelAmount + " liters!");
            }
            latch.countDown();
        });
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }

    public void awaitCompletion() throws InterruptedException {
        latch.await();
    }

    private int getLattency() {
        int min = 3;
        int max = 10;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
