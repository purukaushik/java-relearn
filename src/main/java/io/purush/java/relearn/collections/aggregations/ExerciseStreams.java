package io.purush.java.relearn.collections.aggregations;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Collections;
public class ExerciseStreams {
  public static void main(String[] args){

    Album areYouExp = new Album("Are you exprienced");
    Track track01 = new Track(5);
    Track track02 = new Track(3);
    Track track03 = new Track(4);
    areYouExp.addTrack(track01);areYouExp.addTrack(track02);areYouExp.addTrack(track03);

    Album axis  = new Album("Axis bold as love");
    Track track04 = new Track(1);
    Track track05  = new Track(3);
    Track track06 = new Track(2);
    axis.addTrack(track04);axis.addTrack(track05);axis.addTrack(track06);
    
    List<Album> albums = new ArrayList<>(); albums.add(areYouExp); albums.add(axis);
    
    List<Album> nonStreamy = new ArrayList<>();
    for (Album a : albums) {
      boolean hasFavorite = false;
      for (Track t : a.tracks) {
        if (t.rating >= 4) {
	  hasFavorite = true;
	  break;
        }
      }
      if (hasFavorite)
        nonStreamy.add(a);
    }
    Collections.sort(nonStreamy, new Comparator<Album>() {
	public int compare(Album a1, Album a2) {
	  return a1.name.compareTo(a2.name);
	}});
    System.out.println("Non Streamy -> " + nonStreamy);
    
    List<Album> so = albums.stream().filter(
					  album -> album.tracks.stream().anyMatch( t -> t.rating >= 4)
					  )
      .sorted( (a1, a2) -> a1.name.compareTo(a2.name)).collect(Collectors.toList());
    System.out.println("Streamy -> " + so);
    
  }
}
class Album{
  String name;
  List<Track> tracks  = new ArrayList<>();
  public Album(String name){ this.name = name;}
  public void addTrack(Track track) { tracks.add(track); }

  @Override
  public String toString() { return name + " -> " + tracks; }
}
class Track {
  int rating;
  public Track(int rating){ this.rating =rating;}
  @Override
  public String toString(){ return this.rating+ "" ;} 
}
