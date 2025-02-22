<p align="center">
<img src="demo/itworx.jpeg"/>
</p>

<h1 align="center">ITWORX Education Task</h1>

<p align="center">  
   upon running the application you will face a splash screen , then you will find onboarding screen if we just press next and in last step press on Get Started The OnBoarding Step will not show again ever after that we will must add our preference like country and some categorious then we will face with news When click on any new it will show the chome to open the link , so what the application do ? 
            1 - view all news according selection of source .
            2 - view all top headline sorted by published data .
            3 - add new to saved later and can remove on them .
            4 - search on all news that you want 
</p>
</br>

<img src=".demo/demo.gif" align="right" width="32%"/>










## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection + [Compose](https://developer.android.com/compose) for UI
- JetPack
    - Compose - declartive ui .
    - Lifecycle - dispose of observing data when lifecycle state changes.
    - ViewModel - UI related data holder, lifecycle aware.
    - RunTime Cashe construct a Cache using the abstract layer .
- Architecture
    - MVI Architecture (View - DataBinding - Intent )
    - Modularization ( applied the domain layer as java module 🔥 ).
    - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Room](https://github.com/square/retrofit) - construct the Cache .
- [Gson](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- [Coil](https://square.github.io/picasso/)
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.









### []()License:
Copyright 2025 Mohammed Morse

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


