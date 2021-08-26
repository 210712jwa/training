export interface Pokemon {
  id: number,
  name: string,
  weight: number,
  forms: { 'name': string, 'url': string }[]
}
