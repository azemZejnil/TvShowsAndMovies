# RESTful API application


A showcase of RxJava and Model View Presenter, plus a number of other popular libraries for Android development, including  Retrofit, Moshi, Dagger2, ButterKnife...
Application which pulls data from Themoviedatabase. It lists highest rated movies and tvshows, reviews and trailers.
When you click on a movie, you are transfered to movie details. There is also a search movie/tvshow option

<div align="center">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085613.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085626.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085635.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085712.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085723.png">
</div>

<br>


### Model classes
There are tiny differences in how the classes are structured on the server.
<br>
Because of those differences, I couldn't make same class for all results (both movies and tvshows)
and had to treat them separately.

### Pros of using MVP
This setup has a number of advantages over a non-MVP app architecture
It allows high level of abstraction where each module is dependent on the interface and knows very little about
other modules implementation. That allows making changes easier, easier testing, supporting orientation changes is with less effort and so on.
<br>
The power of RxJava and exposing Observables via the View interface, allows our Presenter to be entirely stateles.



### Dependency injection

For this matter I used Dagger2. 
<br>
There is the 'AppComponent' at the application level which provides every other component (subcomponent*).
Each application component has it's own dependency injection component and each one of them is included into AppComponent.
This way we have everything structured together and it is easy to use (inject) across the application. 