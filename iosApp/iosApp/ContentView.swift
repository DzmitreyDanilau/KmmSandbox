import SwiftUI
import shared

struct ContentView: View {
    
    var body: some View {
        TabView {
            ArtistsView().tabItem {
                Label("Artists", systemImage: "person")
            }
            AlbumsView().tabItem {
                Label("Albums", systemImage: "house")
            }
        }
    }
}
