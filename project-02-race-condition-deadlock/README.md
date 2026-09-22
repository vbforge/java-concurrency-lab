# 🧵 Java Multithreading – Common Concurrency Problems

This project demonstrates several **classic multithreading issues** in Java, explained through small applications and real-life examples.

---

## 📌 app01 — Starvation

### ❓ What is Starvation?

A **processor does not execute threads in true parallelism**.
Instead, it **shares CPU time** between multiple threads.

If a thread has **very low priority**, it may receive **less CPU time** or even **never get executed**.

➡️ This situation is called **starvation**.

### 🧠 Key Idea

* High-priority threads dominate CPU usage
* Low-priority threads wait indefinitely
* The program is technically running, but some threads “starve”

---

## 📌 app02 — Race Condition

### ❓ What is a Race Condition?

A **race condition** occurs when multiple threads try to **access and modify shared data** at the same time.

The final result depends on **which thread wins the race** to access the resource.

### 🧪 Example

```java
int i = 0;

i++;
i--;
```

When executed **in parallel**, the result is **not guaranteed to be `0`**.

### ⚙️ Why does this happen?

The operations `++` and `--` are **NOT atomic**.
Each consists of **two steps**:

1. Read current value of `i`
2. Increment or decrement the value

### 🔍 Problem Scenario

* `IncrementThread` reads `i = 0`
* `DecrementThread` reads `i = 0`, then decrements → `i = -1`
* `IncrementThread` still thinks `i = 0` and increments → `i = 1`

🚨 Result: **work of one thread is lost**

Each run may produce **different results**.

---

## 🔒 Thread-Safe Code

### ✅ What is Thread Safety?

Thread-safe code guarantees:

> **Same input → same output**, regardless of how many threads are running.

### 🧩 `synchronized`

The `synchronized` keyword:

* Prevents **race conditions**
* Ensures only **one thread** accesses critical code at a time

⚠️ However:

> `synchronized` may lead to another serious problem — **Deadlock**

---

## 📌 app03 — Deadlock

### ❓ What is Deadlock?

Deadlock happens when **two or more threads block each other forever**, waiting for resources.

### 🧠 Real-Life Example

We have **two resources**:

* 🎮 Xbox
* 🥁 Drums

#### Situation:

* **Bob** is playing Xbox and wants Drums
* **John** is playing Drums and wants Xbox

🛑 Result:

* Bob waits for Drums
* John waits for Xbox
* Nobody can continue

➡️ This is **Deadlock**

---

### 🛠️ How to Resolve Deadlock

To avoid deadlock:

> **All threads must acquire resources in the SAME ORDER**

✅ Correct Order:

* Bob: Xbox → Drums
* John: Xbox → Drums

This removes circular waiting.

---

## 📌 app04 — Runnable Examples

### 🔧 What is Included?

* Multiple examples of implementing `Runnable`
* Demonstrates how the `run()` method can be **overridden**
* Shows different ways to start threads

---

## ✅ Summary

| Problem        | Description                             |
| -------------- | --------------------------------------- |
| Starvation     | Thread never gets CPU time              |
| Race Condition | Unpredictable result due to shared data |
| Thread Safety  | Same result on every run                |
| Deadlock       | Threads block each other forever        |
| Runnable       | Basic thread creation patterns          |

---

