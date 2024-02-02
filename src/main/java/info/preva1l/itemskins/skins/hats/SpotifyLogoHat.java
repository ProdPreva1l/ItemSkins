package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class SpotifyLogoHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "SpotifyLogoHat";
    }

    @Override
    public int modelData() {
        return 42;
    }

    @Override
    public String name() {
        return "&aSpotify BRRRRRRRRR";
    }
    @Override
    public String permission() {
        return "itemskins.hats.spotifylogo";
    }
}
