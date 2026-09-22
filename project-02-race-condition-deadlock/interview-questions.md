# 🧠 Java Multithreading – Interview Questions

This section contains **common interview questions** related to the multithreading topics covered in this project:
- Starvation
- Race Condition
- Thread Safety
- `synchronized`
- Deadlock
- `Runnable`

---

## 📌 Starvation

### 1️⃣ What is thread starvation?
**Answer:**  
Thread starvation occurs when a thread is unable to gain regular access to CPU or shared resources because other threads with higher priority dominate execution.

---

### 2️⃣ What causes starvation in Java?
**Answer:**
- High-priority threads running continuously
- Poor thread scheduling
- Excessive use of synchronization
- Locks never being released

---

### 3️⃣ How can starvation be prevented?
**Answer:**
- Avoid relying heavily on thread priorities
- Use fair locks (e.g., `ReentrantLock(true)`)
- Design shorter synchronized blocks
- Use thread pools

---

## 📌 Race Condition

### 4️⃣ What is a race condition?
**Answer:**  
A race condition occurs when multiple threads access shared data simultaneously and the final outcome depends on thread execution order.

---

### 5️⃣ Why are `++` and `--` operations not thread-safe?
**Answer:**  
They are compound operations consisting of:
1. Read value
2. Modify value
3. Write value  
These steps can interleave between threads.

---

### 6️⃣ How can race conditions be avoided?
**Answer:**
- Using `synchronized`
- Using atomic classes (`AtomicInteger`)
- Using locks (`ReentrantLock`)
- Avoiding shared mutable state

---

## 📌 Thread Safety

### 7️⃣ What does thread-safe code mean?
**Answer:**  
Thread-safe code guarantees consistent behavior and correct results even when executed concurrently by multiple threads.

---

### 8️⃣ Is `String` thread-safe in Java?
**Answer:**  
Yes, because `String` is immutable. Once created, its value cannot change.

---

### 9️⃣ Can a method be thread-safe but slow?
**Answer:**  
Yes. Excessive synchronization can reduce performance while maintaining correctness.

---

## 📌 synchronized Keyword

### 🔟 What does the `synchronized` keyword do?
**Answer:**  
It ensures that only one thread can execute a synchronized block or method at a time for a given object.

---

### 1️⃣1️⃣ What is the difference between synchronized method and synchronized block?
**Answer:**
- **Synchronized method:** locks the entire method
- **Synchronized block:** locks only a specific section of code

---

### 1️⃣2️⃣ What problems does `synchronized` solve?
**Answer:**
- Race conditions
- Visibility issues

---

### 1️⃣3️⃣ What problems can `synchronized` cause?
**Answer:**
- Deadlock
- Thread contention
- Performance degradation

---

## 📌 Deadlock

### 1️⃣4️⃣ What is deadlock?
**Answer:**  
Deadlock is a situation where two or more threads are waiting indefinitely for resources held by each other.

---

### 1️⃣5️⃣ What are the four necessary conditions for deadlock?
**Answer:**
1. Mutual exclusion
2. Hold and wait
3. No preemption
4. Circular wait

---

### 1️⃣6️⃣ How can deadlock be prevented?
**Answer:**
- Acquire locks in a fixed global order
- Avoid nested locks
- Use timeouts on locks
- Use higher-level concurrency utilities

---

### 1️⃣7️⃣ How can you detect a deadlock?
**Answer:**
- Using thread dumps (`jstack`)
- Monitoring tools (VisualVM, JConsole)

---

## 📌 Runnable & Thread Creation

### 1️⃣8️⃣ What is the difference between `Thread` and `Runnable`?
**Answer:**
- `Thread` is a class
- `Runnable` is a functional interface  
Using `Runnable` allows better separation of logic and execution.

---

### 1️⃣9️⃣ Why is `Runnable` preferred over extending `Thread`?
**Answer:**
- Supports multiple inheritance
- Cleaner design
- Better testability

---

### 2️⃣0️⃣ What happens if you call `run()` directly?
**Answer:**  
The code runs in the current thread, not a new one.

---

### 2️⃣1️⃣ How do you start a thread correctly?
**Answer:**
```java
new Thread(new MyRunnable()).start();
````

---

## 📌 Scenario-Based Questions

### 2️⃣2️⃣ Your application gives different results on each run. What could be the reason?

**Answer:**
Race condition due to unsynchronized access to shared data.

---

### 2️⃣3️⃣ Your application hangs and CPU usage is low. What is a possible cause?

**Answer:**
Deadlock between threads waiting for resources.

---

### 2️⃣4️⃣ A low-priority thread never executes. What is this problem called?

**Answer:**
Thread starvation.

---
