# PokemonSearch

The App consists of two screens
Search Frgament : 
In search frgament we have optoion for search pokmon and will display the pokemon description and pokemon sprites with the help of Services library and Component UI library.
And we have a Add to favourite button which help user to add the dispalyed pokemon deatails to favaorite database.

Favourite Fragment: 
Will show the show the favorites pokemons

The App was developed in MVVM architecture with android jetpack components to make the project lifecycle aware by following the clean code architecture 
and added the test cases for data layer, interactors layer, framworklayer and presentation layer. And also added ViewModel testing.

Technologies Used for PokemonSearch

Kotlin (Clean code architecture)
MVVM architecture
ConstrainLayout
ViewModel data binding
Navigation Graph
Koin Dependency Injection
jUnit, mock, for unit testing
RxJava with executor and scheduler
Coroutines
Retrofit
Glide for loading images


For Service SDK Dependencies used:

kotlin   : "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion",
            rxJava   : "io.reactivex.rxjava2:rxjava:$rxJavaVersion",
            rxAndroid: "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion",
            
            jUnit  : "junit:junit:$junitVersion",
            mockito: "com.nhaarman:mockito-kotlin:$mockitoKotlinVersion"
            
            
For UI Component Dependencies Used

implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.cardview:cardview:1.0.0
    implementation 'androidx.recyclerview:recyclerview:1.1.0'