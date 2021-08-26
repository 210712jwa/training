import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'speedConversion'
})
export class SpeedConversionPipe implements PipeTransform {

  transform(value: number, ...args: string[]): number {
    if (args[0] === 'kph') {
      return 1.60934 * value;
    } else if (args[0] === 'm/s') {
      return 0.44704 * value;
    } else if (args[0] === '') {
      return 1.46667 * value;
    } else return value;
  }

}
