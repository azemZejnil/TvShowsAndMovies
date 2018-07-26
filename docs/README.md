<div align="center">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085613.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085626.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085635.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085712.png">
<img style="float:left;" width="250" height="auto" src="https://github.com/azemZejnil/TvShowsAndMovies/blob/master/docs/imgs/Screenshot_20180725-085723.png">
</div>

<br>

# RESTful API application
Application which pulls data from Themoviedatabase. It lists highest rated movies and tvshows, reviews and trailers.

### Model classes
There are tiny differences in how the classes are structured on the server.
<br>
Because of those differences, I couldn't make same class for all results (both movies and tvshows)
and had to treat them separately.

### Tools and techniques
I used RxJava2, Dagger2, MVP pattern
<br>
For some reason, I couldn't filter out searched tvshows with RxJava2 filter function, I was getting an error.
<br>
Also, there are some irregularities in getting response by searching for a content in the search screen.
However, it is due to API: if you try to make a call in your browser, you get same results

