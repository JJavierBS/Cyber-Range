package com.cyberrange.application.port.in;

import com.cyberrange.domain.model.GameId;

/**
 * Puerto de entrada: el instructor crea una nueva partida en fase de
 * preparacion.
 */
public interface CreateGameUseCase {

    GameId createGame();
}
