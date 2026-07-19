
export interface RestClient {
  get<T>(path: string): Promise<T>;
  post<T>(path: string, body: unknown): Promise<T>;
}

export function createRestClient(): RestClient {
  throw new Error("TODO: implementar cliente REST");
}
