<!-- PROJECT LOGO -->
<p align="center">
  <img src="https://github.com/1lakshy/Notes/blob/master/app/src/main/ic_launcher-playstore.png" alt="Logo" width="120" height="120">
</p>

<h1 align="center">Notes App</h1>

<p align="center">
  A clean and minimalistic Android Notes application built using <b>Jetpack Compose</b>, <b>Kotlin</b>, <b>Firebase</b>, and <b>Dagger Hilt</b>.
  <br />
  <a href="#📱-screenshots"><strong>View Demo »</strong></a>
  <br /><br />
  <img src="https://img.shields.io/badge/Android-Jetpack%20Compose-brightgreen?logo=android&logoColor=white" alt="Android Badge"/>
  <img src="https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white" alt="Kotlin Badge"/>
  <img src="https://img.shields.io/badge/Firebase-Backend-orange?logo=firebase&logoColor=white" alt="Firebase Badge"/>
  <img src="https://img.shields.io/badge/Dagger-Hilt-yellow?logo=google&logoColor=white" alt="Dagger Hilt Badge"/>
  <img src="https://img.shields.io/github/license/yourusername/notes-app?color=blue" alt="License Badge"/>
</p>

---

## 🧠 About the App

**Notes App** helps users create, edit, and organize notes effortlessly with a modern, smooth UI.  
It supports **Firebase sync**, **authentication**, and a **beautiful Jetpack Compose interface**.

✨ **Features**
- 🖊️ Create, edit, and delete notes
- ☁️ Sync notes with Firebase in real-time
- 🔒 User authentication (Firebase Auth)
- 🌙 Dark / Light theme support
- ⚡ Fast, responsive, and clean UI
- 💉 Dependency Injection using Dagger Hilt

---

## 🛠️ Tech Stack

| Category | Tools / Frameworks |
|-----------|--------------------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM + Repository Pattern |
| Backend | Firebase Firestore |
| Authentication | Firebase Auth |
| Dependency Injection | Dagger-Hilt |
| Build System | Gradle (KTS) |

---

## 🏗️ Architecture Overview

Presentation (UI)
↓
ViewModel (State Management)
↓
Repository (Business Logic)
↓
Firebase / Local DB (Data Layer)


🧩 The project follows **Clean Architecture** principles to ensure scalability and testability.

---

## 📱 Screenshots

<p align="center">
  <img src="https://github.com/1lakshy/Notes/blob/master/2.jpeg" alt="Home Screen" width="250" />
  <img src="https://github.com/1lakshy/Notes/blob/master/3.jpeg" alt="Create Note" width="250" />
</p>

> 💡 Place your screenshots inside an `assets/` folder in your repository.

---

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/1lakshy/Notes.git
   ```
Open the project in Android Studio

Sync Gradle to install dependencies

Firebase Setup

Create a Firebase project

Add an Android app in Firebase Console

Download the google-services.json file

Place it in your app directory (app/google-services.json)

Run the app

Connect your device or emulator

Click Run ▶️ in Android Studio

📁 Project Structure
app/
 ├── data/
 │   ├── model/
 │   └── repository/
 ├── di/
 ├── ui/
 │   ├── screens/
 │   └── components/
 ├── viewmodel/
 ├── utils/
 └── MainActivity.kt

🤝 Contributing
Contributions are always welcome!
To contribute:

**Fork this repository**

**Create your feature branch**
```bash
git checkout -b feature/AmazingFeature
```

**Commit your changes**
```bash
git commit -m "Add some AmazingFeature"
```
**Push to the branch**
```bash
git push origin feature/AmazingFeature
```
**Open a Pull Request 🚀**

🪪 License
Distributed under the MIT License.
See LICENSE for more information.

👨‍💻 Author
Lakshy Arun Sharma

📧 Email:lakshy18sharma@gmail.com

🔗 Linkedin: https://www.linkedin.com/in/lakshy-sharma-bab28424b/

💻 Github: https://github.com/1lakshy

⭐ If you like this project, give it a star on GitHub!

