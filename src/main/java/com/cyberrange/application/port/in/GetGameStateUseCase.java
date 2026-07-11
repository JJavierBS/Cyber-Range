package com.cyberrange.application.port.in;

import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameId;

/**
 * Puerto de entrada: consulta de solo lectura del estado actual de una
 * partida (usada por REST y para reconciliar clientes que se reconectan).
 */
public interface GetGameStateUseCase {

    Game getGameState(GameId gameId);
}
