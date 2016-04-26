# RockPaperScissors
This is a rock-paper-scissors implementation that allows to play against the computer.

## API interface
In order to play, execute `java -jar dist/RockPaperScissors.jar` and POST to one of these endpoints:

- `game/play`: Basic ruleset (rock-paper-scissors)
- `game/playExtended`: Extended ruleset (rock-paper-scissors-well)

In the request body, the choosen strategy option needs to be specified in json format:
```
{"choosenStrategy": "ROCK"}
```

Possible strategy options are defined in `Strategy.java` and the request model is `GameRequest.java`.

## Example using curl
```
$ curl -H "Content-Type: application/json" --data '{"choosenStrategy": "ROCK"}' http://localhost:8080/game/play
{"playerStrategy":"ROCK","computerStrategy":"SCISSORS","outcome":"PLAYER_WINS"}
```
