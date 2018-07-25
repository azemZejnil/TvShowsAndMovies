package com.example.bodhi64.tvshowsandmovies.details;

    import dagger.Subcomponent;

@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent {

    void inject(DetailsFragment target);
}
