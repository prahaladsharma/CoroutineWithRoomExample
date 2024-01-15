### Room and Coroutines Example

This example stores the response data of each network request in a Room database. This is essential for any "offline-first" app.
If the `View` requests data, the `ViewModel` first checks if there is data available in the database. If so, this data is returned before performing
a network request to get fresh data.

### Flow
![Coroutine_With_Room](https://github.com/prahaladsharma/CoroutineWithRoomExample/assets/6931557/a88ddc10-e60b-46bd-95fe-94ae11d8fbff)

### Screenshot of Result
![RoomDB](https://github.com/prahaladsharma/CoroutineWithRoomExample/assets/6931557/103d592f-26bd-4cda-bec1-922afea5ff48)

