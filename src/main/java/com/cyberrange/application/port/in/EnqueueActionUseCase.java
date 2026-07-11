package com.cyberrange.application.port.in;

import com.cyberrange.domain.model.ActionIntent;
import com.cyberrange.domain.model.GameId;

/**
 * Puerto de entrada: un atacante o defensor encola una accion para la
 * ronda en curso, dentro de su presupuesto disponible.
 */
public interface EnqueueActionUseCase {

    void enqueueAction(GameId gameId, ActionIntent action);
}
