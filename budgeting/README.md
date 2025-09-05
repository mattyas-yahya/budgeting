# budgeting
aplikasi budgeting 

# 📄 Business Requirement Specification (BRS)

**Project Name:** Budgeting Application  
**Version:** 1.0  
**Date:** 31 Agustus 2025  
**Prepared for:** Development Team  
**Prepared by:** [Matt / Project Owner]

---

## 1. Pendahuluan

### 1.1 Latar Belakang

Perusahaan membutuhkan sistem budgeting yang dapat membantu manajemen dalam:

* Menyusun anggaran biaya per akun (Chart of Account) dan per unit kerja (Cost Center).
* Mencatat realisasi biaya (Actual).
* Membandingkan antara anggaran dan realisasi (Variance Analysis).
* Menyediakan laporan interaktif yang dapat dipakai sebagai dasar pengambilan keputusan.

Saat ini proses budgeting dilakukan manual menggunakan spreadsheet sehingga rawan error, sulit dikontrol, dan tidak scalable.

### 1.2 Tujuan

Membangun aplikasi budgeting internal berbasis web yang:

* **User-friendly**, sederhana digunakan oleh finance dan setiap cost center.
* **Scalable**, bisa dikembangkan ke depannya dengan fitur approval workflow.
* **Integratable**, dapat diintegrasikan ke modul lain (misal accounting atau procurement).

---

## 2. Ruang Lingkup (Scope)

### 2.1 Fitur Utama

1. **Master Data**

   * Chart of Account (COA)
   * Cost Center (CC)
   * User & Role Management (Admin, Finance, CC Owner)

2. **Budget Management**

   * Input & edit budget per COA, per CC, per periode (tahun, bulan).
   * Upload budget via file Excel/CSV.

3. **Actual Management**

   * Input transaksi realisasi per COA, per CC, per periode.
   * Upload realisasi dari file transaksi (opsional).

4. **Variance Report**

   * Perbandingan antara Budget vs Actual.
   * Hitung Variance nominal dan Variance %.
   * Filter berdasarkan tahun, bulan, cost center, dan COA.
   * Export laporan ke Excel/PDF.

5. **Security & Authorization**

   * Admin → akses semua data & master.
   * Finance → input budget, actual, generate report.
   * CC Owner → hanya bisa input & lihat data budget/actual miliknya.

---

## 3. Functional Requirements

### 3.1 Master Data

* Sistem menyimpan daftar **Chart of Account** dengan field:

  * `coa_id` (PK), `coa_code`, `coa_name`, `description`
* Sistem menyimpan daftar **Cost Center** dengan field:

  * `cc_id` (PK), `cc_code`, `cc_name`, `description`
* Admin dapat menambah, mengubah, menghapus data master.

### 3.2 Budget Entry

* User memilih **Cost Center**, **COA**, **Periode (Tahun, Bulan)**.
* User memasukkan nilai budget (decimal).
* Sistem validasi: tidak boleh ada duplikat kombinasi (CC, COA, Tahun, Bulan).

### 3.3 Actual Entry

* User memilih **Cost Center**, **COA**, **Periode (Tahun, Bulan)**.
* User memasukkan nilai realisasi (decimal).
* Sistem validasi: boleh multi-entry dalam 1 bulan, tapi totalnya harus terakumulasi di laporan.

### 3.4 Variance Report

* Sistem menampilkan laporan dengan kolom:

  * `COA Code`, `COA Name`, `Budget`, `Actual`, `Variance`, `Variance%`
* Rumus:

  * Variance = Budget – Actual
  * Variance% = (Variance / Budget) × 100
* Laporan bisa difilter per **Cost Center**, per **Periode**, per **COA**.
* Laporan dapat di-export ke **Excel** atau **PDF**.

### 3.5 User & Role Management

* Login dengan username + password (BCrypt encryption).
* Role menentukan hak akses halaman.
* Mapping User → Cost Center (hanya CC Owner yang bisa akses datanya).

---

## 4. Non-Functional Requirements

1. **Teknologi:**

   * Backend: Spring Boot 3 (Java 17+)
   * Frontend: Thymeleaf, Bootstrap 5, JavaScript minimalis
   * Database: H2 (dev), MySQL/PostgreSQL (production)
   * Security: Spring Security 6 (BCrypt password)

2. **Kinerja:**

   * Mampu memproses hingga 50.000 record budget & actual per tahun tanpa penurunan performa signifikan.

3. **Keamanan:**

   * Password disimpan dalam bentuk hash (BCrypt).
   * Role-based Access Control.

4. **Usability:**

   * UI sederhana, mirip SAP tapi lebih ringan.
   * Semua halaman CRUD harus memiliki form input & tabel data.

---

## 5. Use Case Diagram (Tingkat Tinggi)

**Actors:**

* **Admin**
* **Finance**
* **Cost Center Owner**

**Use Cases:**

* Manage COA (Admin)
* Manage Cost Center (Admin)
* Input Budget (Finance, CC Owner)
* Input Actual (Finance, CC Owner)
* Generate Variance Report (Finance, Admin)

---

## 6. Deliverables

1. Aplikasi Web Spring Boot 3 berjalan di localhost:8080.
2. Database schema otomatis generate via JPA/Hibernate.
3. Dokumentasi API (jika nantinya ada REST endpoint).
4. Manual User sederhana.

---

## 7. Timeline (Estimasi)

* **Week 1:** Setup project Spring Boot, database, konfigurasi security.
* **Week 2:** CRUD Master Data (COA, CC, User).
* **Week 3:** Modul Budget & Actual Entry.
* **Week 4:** Variance Report + Export.
* **Week 5:** Testing, bug fixing, dokumentasi.