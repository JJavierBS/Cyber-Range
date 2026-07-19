/**
 * Cliente de tiempo real hacia el backend (WebSocket)
 */
export interface RealtimeClient {
  connect(gameId: string): void;
  disconnect(): void;
  onMessage(handler: (data: unknown) => void): void;
}

export function createRealtimeClient(): RealtimeClient {
  throw new Error("TODO: implementar cliente de tiempo real (WebSocket)");
}
