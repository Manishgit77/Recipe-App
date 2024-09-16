Recipe App
A simple and intuitive recipe app built using Kotlin and XML for Android. This app allows users to browse, search, and save their favorite recipes.

Features
Browse Recipes: View a list of recipes with images and brief descriptions.
Search Recipes: Search for recipes by name or ingredients.
Recipe Details: View detailed instructions, ingredients, and images for each recipe.
Save Favorites: Save your favorite recipes for quick access.
Screenshots
!Home Screen !Recipe Details

Installation
Clone the repository:
git clone https://github.com/yourusername/recipe-app.git
cd recipe-app

Open the project in Android Studio:
Open Android Studio.
Select Open an existing project.
Navigate to the cloned repository and select it.
Build and run the app:
Connect your Android device or start an emulator.
Click on the Run button in Android Studio.
Dependencies
Retrofit: For network requests.
Hilt: For dependency injection.
Glide: For image loading.
Room: For local database storage.
Add these dependencies in your build.gradle file:

dependencies {
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.google.dagger:hilt-android:2.28-alpha"
    kapt "com.google.dagger:hilt-compiler:2.28-alpha"
    implementation "com.github.bumptech.glide:glide:4.11.0"
    kapt "com.github.bumptech.glide:compiler:4.11.0"
    implementation "androidx.room:room-runtime:2.2.5"
    kapt "androidx.room:room-compiler:2.2.5"
}

Usage
Browse Recipes: Open the app to see a list of recipes.
Search Recipes: Use the search bar to find recipes by name or ingredients.
View Recipe Details: Tap on a recipe to see detailed instructions and ingredients.
Save Favorites: Tap the heart icon to save a recipe to your favorites.
Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

